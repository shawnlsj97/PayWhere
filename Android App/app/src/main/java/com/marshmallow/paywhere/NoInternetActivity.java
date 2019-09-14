package com.marshmallow.paywhere;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Arrays;

/**
 * This is the page where users are directed to when there is loss in internet connectivity.
 * The 'NoInternetActivity' supports methods which include:
 * (i) Setting the view of the activity as designed in R.layout.activity_no_internet.
 * (ii) Checking for internet connectivity.
 * (iii) Showing a custom toast message if there is no internet connection.
 */
public class NoInternetActivity extends AppCompatActivity {

    /**
     * Variable containing 'retry' text that allows users to click on once they have turned on
     * their internet.
     */
    private TextView retry;
    /**
     * Variable for toolbar at top of the page.
     */
    private Toolbar toolBar;
    /**
     * Variable for progress bar after clicking retry.
     */
    private ContentLoadingProgressBar pb;
    /**
     * Variable for connectivity manager that helps us to check for internet connectivity.
     */
    private ConnectivityManager cm;
    /**
     * Variable for broadcast receiver that listens for changes in internet connectivity.
     */
    private BroadcastReceiver networkChangeReceiver;
    /**
     * Variable for boolean that indicates whether the broadcast receiver is registered or not.
     */
    private boolean registered;

    /**
     * Method that initialises the view of our no internet activity.
     * Assigns onClickListener to retry textview.
     * Also instantiates instance of broadcast manager to listen for changes in internet
     * connectivity. Users will be automatically directed to respective page that they would have
     * accessed previously if there was internet connection.
     * @param savedInstanceState Data passed from previous activity (if any).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (restoreThemePref()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

        pb = findViewById(R.id.noInternetPB);
        pb.setVisibility(View.GONE);

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

        // retry button for users to click on when they have turned on their internet connection
        retry = findViewById(R.id.retry_tv);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (haveNetworkConnection()) {
                    pb.setVisibility(View.VISIBLE);
                    retry.setVisibility(View.GONE);

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                            startActivity(searchActivity);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            pb.setVisibility(View.GONE);
                            retry.setVisibility(View.VISIBLE);
                            finish();
                        }
                    }, 1000);
                } else {
                    pb.setVisibility(View.VISIBLE);
                    retry.setVisibility(View.GONE);

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pb.setVisibility(View.GONE);
                            retry.setVisibility(View.VISIBLE);
                        }
                    }, 1000);
                }
            }
        });

        // checks which activity users were on before being directed to this page, enables us to
        // automatically redirect them once internet connection is re-established
        final Bundle bundle = getIntent().getExtras();
        final String activity = bundle.getString("activity");

        networkChangeReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                boolean isConnected = false;
                if (connectivity != null) {
                    NetworkInfo[] info = connectivity.getAllNetworkInfo();
                    if (info != null) {
                        for (int i = 0; i < info.length; i++) {
                            if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                                if (!isConnected) {
                                    isConnected = true;
                                    showOnlineToast();
                                    if (activity.equals("search") || activity.equals("results") || activity.equals("error")) {
                                        String query = bundle.getString("input");
                                        String[] validMalls = getResources().getStringArray(R.array.search_suggestions);
                                        if ((Arrays.asList(validMalls)).contains(toTitleCase(query))) {
                                            Intent searchResults = new Intent(getApplicationContext(), SearchResults.class);
                                            searchResults.putExtra("input", query);
                                            startActivity(searchResults);
                                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                            finish();
                                        } else {
                                            Intent errorIntent = new Intent(getApplicationContext(), ErrorResults.class);
                                            errorIntent.putExtra("input", query);
                                            startActivity(errorIntent);
                                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                            finish();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeReceiver, intentFilter);
        registered = true;

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    /**
     * Checks if there is internet connectivity. Both wifi and mobile data are checked to determine if there is internet connectivity.
     * @return True if internet connectivity exists, false otherwise.
     */
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
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
     * Displays toast message when internet connection is restored.
     */
    public void showOnlineToast() {
        View toastView = getLayoutInflater().inflate(R.layout.online_toast, null);

        Toast toast = Toast.makeText(getApplicationContext(), "Back Online!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM | Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setView(toastView);
        toast.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        if (registered) {
            unregisterReceiver(networkChangeReceiver);
            registered = false;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeReceiver, intentFilter);
        registered = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeReceiver, intentFilter);
        registered = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (registered) {
            unregisterReceiver(networkChangeReceiver);
            registered = false;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (registered) {
            unregisterReceiver(networkChangeReceiver);
            registered = false;
        }
    }

    @Override
    public void finish() {
        super.finish();
        if (registered) {
            unregisterReceiver(networkChangeReceiver);
            registered = false;
        }
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

    private boolean restoreThemePref() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("theme",
                MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark", false);
        return isDark;
    }
}
