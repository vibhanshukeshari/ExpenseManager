package com.calculator.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;

import java.util.Objects;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).hide();

        changeStatusBarColor();


        SignInButton signInButton = findViewById(R.id.sign_in_button);



        signInButton.setSize(SignInButton.SIZE_STANDARD);
        TextView textViewSignIN = (TextView) signInButton.getChildAt(0);
        textViewSignIN.setText(R.string.log_in_with_google);





        findViewById(R.id.sign_in_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//                startActivityForResult(signInIntent, RC_SIGN_IN);


                Toast.makeText(getApplicationContext(),"Sign In pressed",Toast.LENGTH_LONG).show();

            }
        });




    }
    private void changeStatusBarColor() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }
}