package com.squad.stopby;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends AppCompatActivity {

   private FirebaseAuth mAuth;

   private Button menu_postBtn;
   private Button menu_searchBtn;
   private Button menu_profileBtn;
   private Button menu_activeBtn;

   private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth = FirebaseAuth.getInstance();

        menu_postBtn = (Button) findViewById(R.id.menu_postBtn);
        menu_searchBtn = (Button) findViewById(R.id.menu_searchBtn);
        menu_profileBtn = (Button) findViewById(R.id.menu_profileBtn);
        menu_activeBtn = (Button) findViewById(R.id.menu_activeBtn);


        toolbar = (Toolbar) findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);

        menu_postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPost();
            }
        });

        menu_searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSearch();
            }
        });

        menu_profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        menu_activeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ActivePost.class);
                startActivity(intent);
            }
        });
    }

    //authenticate users
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser ==  null) {
            Intent intent = new Intent(this, StartupActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //create the menu on top
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //users sign out
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.main_signout) {
            FirebaseAuth.getInstance().signOut();
            //update UI
            Intent intent = new Intent(this, StartupActivity.class);
            startActivity(intent);
        }
        return true;
    }

    public void toPost(){
        Intent goToPost = new Intent(this, Post.class);
        startActivity(goToPost);
    }

    public void toSearch(){
        Intent goToMap = new Intent(this, MapsActivity.class);
        startActivity(goToMap);
    }
}
