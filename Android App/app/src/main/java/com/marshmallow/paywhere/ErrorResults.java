package com.marshmallow.paywhere;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Arrays;

public class ErrorResults extends AppCompatActivity {

    private Toolbar toolBar;
    private SearchView searchView;
    private TextView textView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_results);
        toolBar = findViewById(R.id.errorToolbar);
        setSupportActionBar(toolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(searchActivity);
                finish();
            }
        });

        searchView = findViewById(R.id.errorSearchView);
        Bundle bundle = getIntent().getExtras();
        String input = bundle.getString("input");
        searchView.setQuery(input, false);

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
                    return false;
                }
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        textView = findViewById(R.id.errorTextView);
        String errorMsg1 = getResources().getString(R.string.error_text_1);
        String errorMsg2 = getResources().getString(R.string.error_text_2);
        textView.setText(errorMsg1 + '\n' + errorMsg2);
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
