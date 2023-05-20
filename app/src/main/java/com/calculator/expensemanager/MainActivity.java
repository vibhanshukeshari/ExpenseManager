package com.calculator.expensemanager;

import static com.calculator.expensemanager.R.*;

import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.bumptech.glide.Glide;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
// Jai swami narayan;
// Project started on 05/05/23 Friday on the birth day of palak;
// Total Number of lines before started - 828;
// Scheduled to be finished on raksha bandhan;
// 3-4 dollars are earning from total paisa and easy loan - 07/05/23

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    private Prefs prefs;
    private TextView profileName;
    private TextView profileEmail;
    private ImageView profilePicture;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FloatingActionButton floatingActionButtonAddTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // making activity full screen
        prefs = new Prefs(getApplicationContext());

        if(!prefs.isLoggedIn()){
            Intent intent = new Intent(this, IntroSlider.class);
            startActivity(intent);
            finish();
        }


        setContentView(layout.activity_main);

        Toolbar toolbar = findViewById(id.myToolBar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(id.navigation_view);
        drawerLayout = findViewById(id.drawer);
        floatingActionButtonAddTransaction = findViewById(id.fab_add);





        BottomAppBar bottomAppBar = findViewById(id.bottomAppBar);

        MaterialShapeDrawable bottomBarBackground = (MaterialShapeDrawable) bottomAppBar.getBackground();
        bottomBarBackground.setShapeAppearanceModel(
                bottomBarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopRightCorner(CornerFamily.ROUNDED,30)
                        .setTopLeftCorner(CornerFamily.ROUNDED,30)
                        .build());




        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        String greeting;
        if (hourOfDay >= 4 && hourOfDay < 12) {
            greeting = "Good Morning";
        } else if (hourOfDay >= 12 && hourOfDay < 17) {
            greeting = "Good Afternoon";
        } else {
            greeting = "Good Evening";
        }
        


        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, string.open, string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(color.white));
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

      Menu menu = navigationView.getMenu();


        ActionBar actionBar = getSupportActionBar();
//
// Set the title and subtitle
        if(actionBar != null){
            actionBar.setTitle(greeting);
        }










        profileName = navigationView.getHeaderView(0).findViewById(id.profile_name);
        profileEmail = navigationView.getHeaderView(0).findViewById(id.profile_email);
        profilePicture = navigationView.getHeaderView(0).findViewById(id.profile_image);
        

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);


        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null){
            String personName = account.getDisplayName();
            String personEmail = account.getEmail();

            String personProfilePic = Objects.requireNonNull(account.getPhotoUrl()).toString();

            Glide.with(this)
                    .load(personProfilePic)
                    .placeholder(drawable.profile_place_holder)
                    .circleCrop()
                    .error(drawable.profile_place_holder)
                    .into(profilePicture);


            profileName.setText(personName);
            if(actionBar != null){
                actionBar.setSubtitle(personName);
            }

            profileEmail.setText(personEmail);
        } else{
            profileName.setText(greeting);
            if(actionBar != null){
                actionBar.setSubtitle(string.guest);
            }
            profileEmail.setText(string.guest);
        }

        
        
        
        
        
        
        
        floatingActionButtonAddTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Transaction.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_bottom, anim.animation_stay);


            }
        });
























































    }




    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    // it is used to fixed the text size
//    @Override
//    public Resources getResources() {
//        Resources res = super.getResources();
//        Configuration config = new Configuration();
//        config.setToDefaults();
//        res.updateConfiguration(config, res.getDisplayMetrics());
//        return res;
//    }
}