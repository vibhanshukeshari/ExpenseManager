package com.calculator.expensemanager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class IntroSlider extends AppCompatActivity {
    private ViewPager viewPager;
    private MaterialButton btnPrevious,btnNext;
    private MaterialButton btnGetStarted;
    private SliderPagerAdapter adapter;
    private Prefs prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // making activity full screen

        getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_intro_slider);


        prefs = new Prefs(getApplicationContext());
        // hide action bar you can use NoAction theme as well
//        Objects.requireNonNull(getSupportActionBar()).hide();
        // bind views
        viewPager = findViewById(R.id.pagerIntroSlider);
        TabLayout tabLayout = findViewById(R.id.tabs);
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_get_started);
        // init slider pager adapter
        adapter = new SliderPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        // set adapter
        viewPager.setAdapter(adapter);
        // set dot indicators
        tabLayout.setupWithViewPager(viewPager);
        // make status bar transparent
        changeStatusBarColor();


        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() -1);
            }
        });



        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
//                if (viewPager.getCurrentItem() < adapter.getCount()) {
//                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//                }


                // shared prefrences to be used vibhu(07/05/23)

                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();

            }
        });




        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override public void onPageSelected(int position) {

                if(position == 0) {
                    btnPrevious.setVisibility(View.GONE);
                    btnNext.setVisibility(View.VISIBLE);
                    btnGetStarted.setVisibility(View.GONE);
                } else if(position == 1){
                    btnPrevious.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.VISIBLE);
                    btnGetStarted.setVisibility(View.GONE);
                } else if(position == 2){
                    btnPrevious.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.VISIBLE);
                    btnGetStarted.setVisibility(View.GONE);
                } else if(position == 3){

                    btnPrevious.setVisibility(View.GONE);
                    btnNext.setVisibility(View.GONE);
                    btnGetStarted.setVisibility(View.VISIBLE);

                }
            }
            @Override public void onPageScrollStateChanged(int state) {
            }
        });
    }
    private void changeStatusBarColor() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }
}