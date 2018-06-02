package com.example.eldho.onboardingscreensample;
/**
 * If we want different backgrounds for different pages - > create different slide_layouts
 * Create slider Adapter
 * Initialize the sliderAdapter
 * Create dot indicator
 */

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewpager;
    private LinearLayout mDotLayout;

    private TextView mDots[]; // for dots

    private SliderAdapter sliderAdapter;


    //Indicates the dot change in color according to the pages
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewpager = findViewById(R.id.mainVP);
        mDotLayout = findViewById(R.id.dotsLL);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewpager.setAdapter(sliderAdapter);
        addDotIndicator(0);

        mSlideViewpager.addOnPageChangeListener(viewListener); //adding on change page listener to our page
    }

    // Adding dots
    public void addDotIndicator(int position) {
        mDots = new TextView[3];

        mDotLayout.removeAllViews(); // fixes dots on all page

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }
}
