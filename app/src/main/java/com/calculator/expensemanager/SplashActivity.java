package com.calculator.expensemanager;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private Prefs prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // It is used to prevent app to intent multiple activity in the stack . It happens after user press home button and then open app again.
        if(!isTaskRoot()) {
            final Intent intent = getIntent();
            if(intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(intent.getAction())) {
                finish();
                return;
            }
        }

        changeStatusBarColor();


        prefs = new Prefs(getApplicationContext());


        if(!prefs.isLoggedIn()){
            Intent intent=new Intent(SplashActivity.this,IntroSlider.class);
            startActivity(intent);
            finish();

        } else {
            Intent intent=new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }



    }


    private void changeStatusBarColor() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }



}