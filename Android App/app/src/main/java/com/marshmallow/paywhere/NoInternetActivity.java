package com.marshmallow.paywhere;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;

public class NoInternetActivity extends AppCompatActivity {

    private TextView retry;
    private Toolbar toolBar;
    private ContentLoadingProgressBar pb;
    private ConnectivityManager cm;
    private BroadcastReceiver networkChangeReceiver;
    private boolean registered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        retry = findViewById(R.id.reset_tv);
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
                                    if (activity.equals("main")) {
                                        Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                                        startActivity(searchActivity);
                                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                        finish();
                                    } else if (activity.equals("search") | activity.equals("results") | activity.equals("error")) {
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
    }

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
    }
