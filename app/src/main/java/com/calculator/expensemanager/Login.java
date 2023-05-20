package com.calculator.expensemanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Objects;

public class Login extends AppCompatActivity {


    private Prefs prefs;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        setContentView(R.layout.activity_login);

//        Objects.requireNonNull(getSupportActionBar()).hide();

        changeStatusBarColor();


        SignInButton signInButton = findViewById(R.id.sign_in_button);


        prefs = new Prefs(getApplicationContext());



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);





        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null){

            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            finish();
            prefs.setIsLogin(true);


        }


//        signInButton.setSize(SignInButton.SIZE_STANDARD);
//        TextView textViewSignIN = (TextView) signInButton.getChildAt(0);
//        textViewSignIN.setText(R.string.log_in_with_google);





        findViewById(R.id.sign_in_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();


            }
        });


        findViewById(R.id.btn_skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                prefs.setIsLogin(true);
                finish();

            }
        });


    }
    private void changeStatusBarColor() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

   void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,9001);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 9001) {
            Task<GoogleSignInAccount> Task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                Task.getResult(ApiException.class);
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                prefs.setIsLogin(true);
                finish();

            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
                prefs.setIsLogin(false);
            }
        }
    }
    }
