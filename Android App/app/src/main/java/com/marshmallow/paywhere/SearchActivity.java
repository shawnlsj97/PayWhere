package com.marshmallow.paywhere;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Point;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Constraints;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;

import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private SearchView searchView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
                finish();
            }
        });
        searchView = findViewById(R.id.searchView);
        searchView.requestFocus();
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
                String[] validMalls = getResources().getStringArray(R.array.search_suggestions);
                if ((Arrays.asList(validMalls)).contains(toTitleCase(query))) {
                    Intent intent = new Intent(getApplicationContext(), SearchResults.class);
                    intent.putExtra("input", query);
                    startActivity(intent);
                    searchView.clearFocus();
                    return true;
                } else {
                    Intent errorIntent = new Intent(getApplicationContext(), ErrorResults.class);
                    errorIntent.putExtra("input", query);
                    startActivity(errorIntent);
                    return true;
                }
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
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


