package com.marshmallow.paywhere;

import android.content.Intent;
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
 * This is the secondary onboarding page that users view when they click on the info icon on the
 * main page. Unlike the original onboarding page, users immediately have access to the get
 * started button to return to the home page immediately without having to go through the entire
 * onboarding process.
 * The 'OnboardingSecondary' class supports methods which include:
 * (i) Setting the view of the activity as designed in R.layout.onboarding.
 * (ii) Adding dots indicator which inform users which page their they currently viewing.
 */
public class OnboardingSecondary extends AppCompatActivity {

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
     * @param savedInstanceState Data passed from previous activity (if any).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        if (position == 0) {
            get_started_btn.setVisibility(View.VISIBLE);
            get_started_btn.setAnimation(btn_anim);
        }

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
}
