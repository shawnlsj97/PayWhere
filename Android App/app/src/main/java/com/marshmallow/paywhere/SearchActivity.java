package com.marshmallow.paywhere;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * This is the page where users input their mall that they intend to visit.
 * The 'SearchActivity' class supports methods which include:
 * (i) Setting the view of the activity as designed in R.layout.activity_search.
 * (ii) Converting input query to title case.
 * (iii) Checking for internet connectivity.
 * (iv) Showing a custom toast message if there is no internet connection.
 */
public class SearchActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private SearchView searchView;
    private ArrayList<String> searchSuggestions;

    /**
     * Method that initialises the view of our search activity.
     * Assigns onClickListeners to searchView and imageView.
     * On click, searchView will lead to the results page if the query is valid, or to the error
     * page if the query is invalid.
     * @param savedInstanceState Data passed from previous activity (if any).
     */
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Check if user has selected Night Mode and sets the theme accordingly
        setAppTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        configureToolbar();
        // Automatically bring focus to searchview which brings up the keyboard for input.
        focusOnSearchview();
        configureSearchSuggestions(this);
        addSearchFunctionality();
    }

    private void configureToolbar() {
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void focusOnSearchview() {
        searchView = findViewById(R.id.searchView);
        searchView.requestFocus();
    }

    private void configureSearchSuggestions(final Context c) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("malls");
        searchSuggestions = new ArrayList<>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                searchSuggestions = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String mallName = ds.getKey();
                    searchSuggestions.add(toTitleCase(mallName));
                }
                Collections.sort(searchSuggestions, String.CASE_INSENSITIVE_ORDER);
                SearchView.SearchAutoComplete searchAutoComplete =
                        searchView.findViewById(androidx.appcompat.R.id.search_src_text);
                String[] suggestions = searchSuggestions.toArray(new String[0]);
                ArrayAdapter suggestionAdapter = new ArrayAdapter(c, R.layout.suggestion_item,
                        R.id.suggestion, suggestions);
                searchAutoComplete.setAdapter(suggestionAdapter);
                // Suggestions only appear after input of first letter
                searchAutoComplete.setThreshold(1);
                // Clicking on suggestion immediately proceeds with search
                searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = (String) parent.getAdapter().getItem(position);
                        searchView.setQuery(item, true);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });
    }

    private void addSearchFunctionality() {
        // If have internet connection, check if query is valid. If valid, proceed to results
        // page, else proceed to error page. If no internet connection, go to error page.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (haveNetworkConnection()) {
                    String[] validMalls = searchSuggestions.toArray(new String[0]);
                    if ((Arrays.asList(validMalls)).contains(toTitleCase(query))) {
                        Intent intent = new Intent(getApplicationContext(), SearchResults.class);
                        intent.putExtra("input", query);
                        intent.putExtra("suggestions", searchSuggestions.toArray(new String[0]));
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        searchView.clearFocus();
                        return true;
                    } else {
                        Intent errorIntent = new Intent(getApplicationContext(), ErrorResults.class);
                        errorIntent.putExtra("input", query);
                        errorIntent.putExtra("suggestions",
                                searchSuggestions.toArray(new String[0]));
                        startActivity(errorIntent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    }
                } else {
                    showOfflineToast();
                    Intent noInternetActivity = new Intent(getApplicationContext(), NoInternetActivity.class);
                    noInternetActivity.putExtra("activity", "search");
                    noInternetActivity.putExtra("input", query);
                    startActivity(noInternetActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return false;
                }
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        searchView.setQuery("",false);
        searchView.requestFocus();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    /**
     * Checks if there is internet connectivity. Both wifi and mobile data are checked to determine if there is internet connectivity.
     * @return True if internet connectivity exists, false otherwise.
     */
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    /**
     * Displays toast message informing user that there is no network connection.
     */
    public void showOfflineToast() {
        View toastView = getLayoutInflater().inflate(R.layout.offline_toast, null);

        Toast toast = Toast.makeText(getApplicationContext(), "No Connection :(", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM | Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setView(toastView);
        toast.show();
    }

    private boolean isThemeDark() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("theme",
                MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark", false);
        return isDark;
    }

    /**
     * Converts input query to title case.
     * @param input Input string from user.
     * @return String that is converted from user input to title case.
     */
    public String toTitleCase(String input) {

        StringBuilder output = new StringBuilder();
        boolean convertNext = true;
        for (char ch : input.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            output.append(ch);
        }

        return output.toString();
    }

    private void setAppTheme() {
        if (isThemeDark()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            setTheme(R.style.DarkTheme);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            setTheme(R.style.AppTheme);
        }
    }
}


