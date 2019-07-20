package com.marshmallow.paywhere;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Splash page that users first see everytime the app is launched. Will automatically proceed to
 * the app onboarding activity.
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * Immediately starts and attempts to proceed to Onboarding activity (so splash is for time
     * needed to load Onboarding only).
     * @param savedInstanceState Data passed from previous activity (if any).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, Onboarding.class);
        startActivity(intent);
        finish();
    }
}
