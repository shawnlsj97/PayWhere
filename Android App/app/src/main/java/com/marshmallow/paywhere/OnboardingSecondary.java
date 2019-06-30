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

public class OnboardingSecondary extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;
    private Button get_started_btn;

    private Animation btn_anim;

    private ImageView paymentOptions, exampleSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_onboarding);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        get_started_btn = findViewById(R.id.get_started_btn);
        btn_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.get_started_btn_anim);
        paymentOptions = findViewById(R.id.payment_imageView);
        exampleSearch = findViewById(R.id.searchExample_imageView);

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
            mDots[i].setTextColor(getColor(R.color.statusBar));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0) {
            mDots[position].setTextColor(getColor(R.color.colorPrimary));
        }

        if (position ==  mDots.length - 2) {
            paymentOptions.setVisibility(View.VISIBLE);
        } else {
            paymentOptions.setVisibility(View.INVISIBLE);
        }

        if (position == mDots.length - 3) {
            exampleSearch.setVisibility(View.VISIBLE);
        } else {
            exampleSearch.setVisibility(View.INVISIBLE);
        }
    }

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
