package com.marshmallow.paywhere;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FavouritesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FavouritesAdapter adapter;

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
        setContentView(R.layout.activity_favourites);

        toolbar = findViewById(R.id.favourites_toolbar);
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

        recyclerView = findViewById(R.id.favourites_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        ArrayList<String> malls = new ArrayList<>();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("fav",
                MODE_PRIVATE);
        Set<String> malls_set = pref.getStringSet("malls", new TreeSet<String>());
        Iterator<String> set_iterator = malls_set.iterator();
        for (int i = 0; i < malls_set.size(); i++) {
            String name = set_iterator.next();
            malls.add(name);
            Collections.sort(malls);
        }
        pref.edit().putStringSet("malls", malls_set).apply();

        Activity activity = this;
        adapter = new FavouritesAdapter(malls, getApplicationContext(), activity);
        recyclerView.setAdapter(adapter);

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<String> malls = new ArrayList<>();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("fav",
                MODE_PRIVATE);
        Set<String> malls_set = pref.getStringSet("malls", new TreeSet<String>());
        Iterator<String> set_iterator = malls_set.iterator();
        for (int i = 0; i < malls_set.size(); i++) {
            String name = set_iterator.next();
            malls.add(name);
            Collections.sort(malls);
        }

        Activity activity = this;
        adapter = new FavouritesAdapter(malls, getApplicationContext(), activity);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private boolean restoreThemePref() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("theme",
                MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark", false);
        return isDark;
    }
}
