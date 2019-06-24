package com.marshmallow.paywhere;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.onboard_logo,
            R.drawable.pin_drop,
            R.drawable.filter_tool,
            R.drawable.thumbs_up
    };

    public String[] step_headings = {
            "",
            "Step 1",
            "Step 2",
            "Step 3"
    };

    public String[] slide_headings = {
            "Thank you for choosing PayWhere!",
            "Choose a shopping mall.",
            "Filter by your preferred mobile payment option.",
            "Enjoy your meal along with easy payment!"
    };

    public String[] slide_desc = {
            "Swipe to learn how to use our app.",
            "",
            "",
            ""
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.slideImageView);
        TextView stepHeading = view.findViewById(R.id.stepHeading);
        TextView slideHeading = view.findViewById(R.id.slideHeading);
        TextView slideDesc = view.findViewById(R.id.slideDesc);

        slideImageView.setImageResource(slide_images[position]);
        stepHeading.setText(step_headings[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
