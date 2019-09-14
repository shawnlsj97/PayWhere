package com.marshmallow.paywhere;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SettingsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Switch theme_switch;

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
        setContentView(R.layout.activity_settings);

        toolbar = findViewById(R.id.settings_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(true);
        // Up button has same behavior as back button.
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        theme_switch = findViewById(R.id.theme_switch);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            theme_switch.setChecked(true);
        }
        theme_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    saveThemePref("dark");
                    refreshApp();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    saveThemePref("light");
                    refreshApp();
                }
            }
        });

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private void refreshApp() {
        Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void saveThemePref(String mode) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("theme",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (mode.equals("dark")) {
            editor.putBoolean("isDark", true);
        } else {
            editor.putBoolean("isDark", false);
        }
        editor.apply();
    }

    private boolean restoreThemePref() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("theme",
                MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark", false);
        return isDark;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
