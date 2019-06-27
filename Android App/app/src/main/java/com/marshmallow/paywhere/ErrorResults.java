package com.marshmallow.paywhere;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ErrorResults extends AppCompatActivity {

    private Toolbar toolBar;
    private SearchView searchView;
    private TextView textView;

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

        textView = findViewById(R.id.errorTextView);
        String errorMsg1 = getResources().getString(R.string.error_text_1);
        String errorMsg2 = getResources().getString(R.string.error_text_2);
        textView.setText(errorMsg1 + '\n' + errorMsg2);
    }
}
