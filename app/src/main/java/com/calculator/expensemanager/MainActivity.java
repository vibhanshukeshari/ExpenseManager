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
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;
// Jai swami narayan;
// Project started on 05/05/23 Friday on the birth day of palak;
// Total Number of lines before started - 828;
// Scheduled to be finished on raksha bandhan;
// 3-4 dollars are earning from total paisa and easy loan - 07/05/23

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // making activity full screen

        // to be put conditions
        Intent intent = new Intent(this, IntroSlider.class);
        startActivity(intent);
        finish();


        setContentView(R.layout.activity_main);



    }

}