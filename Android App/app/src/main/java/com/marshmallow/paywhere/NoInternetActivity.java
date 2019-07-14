package com.marshmallow.paywhere;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
                                    Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                                    startActivity(searchActivity);
                                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                    finish();
                                }
                            }
                        }
                    }
                } else {
                    isConnected = false;
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
}
