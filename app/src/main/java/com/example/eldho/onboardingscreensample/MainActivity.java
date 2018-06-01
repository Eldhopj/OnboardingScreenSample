package com.example.eldho.onboardingscreensample;
/**If we want different backgrounds for different pages - > create different slide_layouts
 *Create slider Adapter
 * Initialize the sliderAdapter*/
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewpager;
    private LinearLayout mDotLayout;

    private SliderAdapter sliderAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewpager = findViewById(R.id.mainVP);
        mDotLayout = findViewById(R.id.dotsLL);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewpager.setAdapter(sliderAdapter);
    }
}
