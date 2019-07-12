package com.marshmallow.paywhere;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

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
                Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(searchActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(searchActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
}
