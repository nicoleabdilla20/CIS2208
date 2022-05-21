package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_2);
        // variable initialised and declared
        Button lo = findViewById(R.id.lo);
        lo.setOnClickListener(v -> openActivity3());

        Button log = findViewById(R.id.log);
        log.setOnClickListener(v -> openActivity4());
    }
    // displays activity signup
    public void openActivity3 (){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
    // displays activity login
    public void openActivity4 (){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}