package com.marshmallow.paywhere;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * This is the onboarding page that users view when they launch PayWhere for the very first time.
 * The 'Onboarding' class supports methods which include:
 * (i) Setting the view of the activity as designed in R.layout.onboarding.
 * (ii) Adding dots indicator which inform users which page their they currently viewing.
 */
public class Onboarding extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private Button get_started_btn;
    private Animation btn_anim;

    /**
     * Method that initialises the view of our onboarding activity.
     * Assigns onClickListener to get started button.
     * On click, get started button will lead to the main page of our app.
     * Checks whether user has completed onboarding. If done, user will automatically be
     * redirected to main page.
     * @param savedInstanceState Data passed from previous activity (if any).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //check if tutorial completed
        if (restorePrefData()) {
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
            finish();
        }

        setContentView(R.layout.activity_onboarding);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        get_started_btn = findViewById(R.id.get_started_btn);
        btn_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.get_started_btn_anim);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        get_started_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);

                //boolean to keep track whether user has completed tutorial
                savePrefsData();
                finish();
            }
        });
    }

    /**
     * Adds dots indicator based on page number.
     * @param position Page number of slide view.
     */
    public void addDotsIndicator(int position) {
        mDots = new TextView[sliderAdapter.getCount()];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getColor(R.color.grey));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0) {
            mDots[position].setTextColor(getColor(R.color.colorPrimary));
        }

        if(position == mDots.length - 1) {
            get_started_btn.setVisibility(View.VISIBLE);
            get_started_btn.setAnimation(btn_anim);
        }
    }

    /**
     * Listener that adds the dots indicated based on page number.
     */
    ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    /**
     * Retrieve info if user has completed onboarding.
     * @return True if onboarding completed, false otherwise.
     */
    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        boolean isOnboardingDone = pref.getBoolean("isOnboardingDone", false);
        return isOnboardingDone;
    }

    /**
     * Saves info that user has completed onboarding.
     */
    public void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isOnboardingDone", true);
        editor.apply();
    }
}
