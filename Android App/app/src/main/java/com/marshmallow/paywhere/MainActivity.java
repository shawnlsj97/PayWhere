package com.marshmallow.paywhere;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.clearFocus();
                if (haveNetworkConnection()) {
                    Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                    startActivity(searchActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else {
                    showOfflineToast();
                    Intent noInternetActivity = new Intent(getApplicationContext(), NoInternetActivity.class);
                    startActivity(noInternetActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (haveNetworkConnection()) {
                    Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                    startActivity(searchActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else {
                    showOfflineToast();
                    Intent noInternetActivity = new Intent(getApplicationContext(), NoInternetActivity.class);
                    noInternetActivity.putExtra("activity", "main");
                    startActivity(noInternetActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });

        imageView = findViewById(R.id.infoImageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent onboardingActivity = new Intent(getApplicationContext(), OnboardingSecondary.class);
                startActivity(onboardingActivity);
            }
        });
    }

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

    public void showOfflineToast() {
        View toastView = getLayoutInflater().inflate(R.layout.offline_toast, null);

        Toast toast = Toast.makeText(getApplicationContext(), "No Connection :(", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM | Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setView(toastView);
        toast.show();
    }
}
