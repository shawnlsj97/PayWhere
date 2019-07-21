package com.marshmallow.paywhere;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This is the page where the list of dining outlets in a particular mall selected by the user is
 * displayed..
 * The 'SearchResults' class supports methods which include:
 * (i) Setting the view of the activity as designed in R.layout.activity_search_results.
 * (ii) Converting input query to title case.
 * (iii) Performing data retrieval on firebase for valid inputs.
 * (iv) Checking for internet connectivity.
 * (v) Showing a custom toast message if there is no internet connection.
 */
public class SearchResults extends AppCompatActivity {

    /**
     * Variable for toolbar at top of the page.
     */
    private Toolbar toolBar;
    /**
     * Variable for searchview embedded in toolbar.
     */
    private SearchView searchView;
    /**
     * Variable for recyclerview containing all the mall data.
     */
    private RecyclerView recyclerView;
    /**
     * Variable for adapter for recyclerview that attaches data to the view.
     */
    private RecyclerAdapter adapter;
    /**
     * Variable for the progressbar shown while data is fetched from firebase.
     */
    private ContentLoadingProgressBar pb;
    /**
     * Variable for input from user.
     */
    private String originalText;
    /**
     * Variable for the bar containing filter button.
     */
    private ConstraintLayout filterBar;
    /**
     * Variable for filter dialog.
     */
    private Dialog filterDialog;
    /**
     * Variable for dash checkbox in the filter dialog.
     */
    private CheckedTextView dash;
    /**
     * Variable for grab checkbox in the filter dialog.
     */
    private CheckedTextView grab;
    /**
     * Variable for nets checkbox in the filter dialog.
     */
    private CheckedTextView nets;
    /**
     * Variable for list of all stores in the mall that user has input.
     */
    private ArrayList<Store> stores;

    /**
     * Method that initialises the view of our SearchResults activity.
     * Assigns onClickListeners to our up button and searchview.
     * Also initialises the recyclerview and calls the method firebaseSearch to retrieve data
     * from the database.
     * @param savedInstanceState
     */
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        pb = findViewById(R.id.progress_bar);
        toolBar = findViewById(R.id.successToolbar);
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

        searchView = findViewById(R.id.successSearchView);
        Bundle bundle = getIntent().getExtras();
        String input = bundle.getString("input");
        originalText = input;
        searchView.setQuery(toTitleCase(input), false);
        searchView.clearFocus();

        final SearchView.SearchAutoComplete searchAutoComplete = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        ArrayAdapter suggestionAdapter = new ArrayAdapter(this, R.layout.suggestion_item, R.id.suggestion, getResources().getStringArray(R.array.search_suggestions));
        searchAutoComplete.setAdapter(suggestionAdapter);
        searchAutoComplete.setThreshold(1);
        searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getAdapter().getItem(position);
                searchView.setQuery(item, true);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (haveNetworkConnection()) {
                    String[] validMalls = getResources().getStringArray(R.array.search_suggestions);
                    if ((Arrays.asList(validMalls)).contains(toTitleCase(query))) {
                        Intent intent = new Intent(getApplicationContext(), SearchResults.class);
                        intent.putExtra("input", query);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        searchView.clearFocus();
                        return true;
                    } else {
                        Intent errorIntent = new Intent(getApplicationContext(), ErrorResults.class);
                        errorIntent.putExtra("input", query);
                        startActivity(errorIntent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    }
                } else {
                    showOfflineToast();
                    Intent noInternetActivity = new Intent(getApplicationContext(), NoInternetActivity.class);
                    noInternetActivity.putExtra("activity", "results");
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

        filterDialog = new Dialog(this);
        filterDialog.setContentView(R.layout.filter_dialog);
        dash = filterDialog.findViewById(R.id.dialog_dash);
        grab = filterDialog.findViewById(R.id.dialog_grab);
        nets = filterDialog.findViewById(R.id.dialog_nets);

        // after clicking cancel, all check boxes reset to unchecked state
        Button cancel_btn = filterDialog.findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterDialog.dismiss();
                dash.setCheckMarkDrawable(null);
                dash.setChecked(false);
                dash.setTextColor(getColor(R.color.textColor));
                grab.setCheckMarkDrawable(null);
                grab.setChecked(false);
                grab.setTextColor(getColor(R.color.textColor));
                nets.setCheckMarkDrawable(null);
                nets.setChecked(false);
                nets.setTextColor(getColor(R.color.textColor));
            }
        });

        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dash.isChecked()) {
                    dash.setTextColor(getColor(R.color.textColor));
                    dash.setCheckMarkDrawable(null);
                    dash.setChecked(false);
                } else {
                    dash.setTextColor(getColor(R.color.colorPrimary));
                    dash.setCheckMarkDrawable(R.drawable.dialog_tick);
                    dash.setChecked(true);
                }
            }
        });

        grab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (grab.isChecked()) {
                    grab.setTextColor(getColor(R.color.textColor));
                    grab.setCheckMarkDrawable(null);
                    grab.setChecked(false);
                } else {
                    grab.setTextColor(getColor(R.color.colorPrimary));
                    grab.setCheckMarkDrawable(R.drawable.dialog_tick);
                    grab.setChecked(true);
                }
            }
        });

        nets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nets.isChecked()) {
                    nets.setTextColor(getColor(R.color.textColor));
                    nets.setCheckMarkDrawable(null);
                    nets.setChecked(false);
                } else {
                    nets.setTextColor(getColor(R.color.colorPrimary));
                    nets.setCheckMarkDrawable(R.drawable.dialog_tick);
                    nets.setChecked(true);
                }
            }
        });

        filterBar = findViewById(R.id.filterBar);
        filterBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterDialog.show();
            }
        });

        // perform filtering based on what is checked by users after they click on apply btn
        // create new list of stores and use it to create new adapter for the recyclerview to use
        Button apply_btn = filterDialog.findViewById(R.id.apply_btn);
        apply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean dash_checked = dash.isChecked();
                boolean grab_checked = grab.isChecked();
                boolean nets_checked = nets.isChecked();

                if (!dash_checked && !grab_checked && !nets_checked) {
                    // none of the options are checked
                    recyclerView.setAdapter(adapter);
                    runLayoutAnimation(recyclerView);
                    filterDialog.dismiss();
                } else {
                    ArrayList<Store> filteredList = new ArrayList<>();
                    for (Store s : stores) {
                        String payment = s.getPayment();
                        if (dash_checked) {
                            if (payment.contains("Dash")) {
                                if (!filteredList.contains(s)) filteredList.add(s);
                            }
                        }
                        if (grab_checked) {
                            if (payment.contains("GrabPay")) {
                                if (!filteredList.contains(s)) filteredList.add(s);
                            }
                        }
                        if (nets_checked) {
                            if (payment.contains("NetsQR")) {
                                if (!filteredList.contains(s)) filteredList.add(s);
                            }
                        }
                    }
                    // sort stores based on name lexicographically ignoring case
                    Collections.sort(filteredList, new StoreComparator());
                    RecyclerAdapter recyclerAdapter = new RecyclerAdapter(filteredList, getApplicationContext());
                    recyclerView.setAdapter(recyclerAdapter);
                    runLayoutAnimation(recyclerView);
                    filterDialog.dismiss();
                }
            }
        });

        recyclerView = findViewById(R.id.successRecyclerView);
        recyclerView.setVisibility(View.INVISIBLE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        firebaseSearch(input.toLowerCase());
    }

    /**
     * Perform search on firebase using input string from user.
     * @param input User input in lower case.
     */
    private void firebaseSearch(final String input) {
        // search by mall
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference(input);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stores = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (ds.child("image").getValue() == null) {
                        stores.add(new Store(ds.child("name").getValue().toString(),
                                ds.child("payment").getValue().toString(),
                                ds.child("address").getValue().toString(),
                                ""));
                    } else {
                        stores.add(new Store(ds.child("name").getValue().toString(),
                                ds.child("payment").getValue().toString(),
                                ds.child("address").getValue().toString(),
                                ds.child("image").getValue().toString()));
                    }
                }
                // sort stores based on name lexicographically ignoring case
                Collections.sort(stores, new StoreComparator());
                adapter = new RecyclerAdapter(stores, getApplicationContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setVisibility(View.VISIBLE);
                pb.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });
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

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    protected void onResume() {
        super.onResume();
        searchView.setQuery(originalText,false);
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

    /**
     * Rerun animation when data set change (e.g. when user filters data).
     * @param recyclerView Recyclerview containing all store data.
     */
    public void runLayoutAnimation(RecyclerView recyclerView) {

        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context, R.anim.recyclerview_layout_anim);

        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}
