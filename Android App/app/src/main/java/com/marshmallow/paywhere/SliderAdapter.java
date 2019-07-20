package com.marshmallow.paywhere;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Adapter for our slide viewpager on the onboarding page.
 * The 'SliderAdapter' class supports methods which include:
 * (i) Getting the total number of pages.
 * (ii) Setting the content on the current page based on page number.
 */
public class SliderAdapter extends PagerAdapter {

    /**
     * Application context.
     */
    Context context;
    /**
     * Inflates layout we have created in slide_layout.xml.
     */
    LayoutInflater layoutInflater;

    /**
     * Constructor that creates an instance of the SliderAdapter class and assigns the
     * application context to the instance.
     * @param context Application context.
     */
    public SliderAdapter(Context context) {
        this.context = context;
    }

    /**
     * Integer array containing title icons on each page.
     */
    public int[] slide_images = {
            R.drawable.onboard_logo,
            R.drawable.pin_drop,
            R.drawable.filter_tool,
            R.drawable.thumbs_up
    };

    /**
     * String array containing step headings on each page.
     */
    public String[] step_headings = {
            "",
            "Step 1",
            "Step 2",
            "Step 3"
    };

    /**
     * String array containing titles on each page.
     */
    public String[] slide_headings = {
            "Thank you for choosing PayWhere!",
            "Choose a shopping mall.",
            "Filter by your preferred mobile payment option.",
            "Enjoy your meal along with easy payment!"
    };

    /**
     * String array containing descriptions on each page.
     */
    public String[] slide_desc = {
            "Swipe to learn how to use our app.",
            "",
            "",
            ""
    };

    /**
     * Method that returns number of pages in the slider.
     * @return Integer representing total number of pages.
     */
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    /**
     * Sets the content on each page using the position of each page to retrieve the appropriate
     * objects from the arrays above.
     * @param container ViewGroup containing all our objects on the page.
     * @param position Page number.
     * @return Object that represents our page layout.
     */
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

    /**
     * Remove page once it is out of view.
     * @param container Container containing layout.
     * @param position Page number.
     * @param object  Layout containing data.
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
