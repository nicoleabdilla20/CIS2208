package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Feedback extends AppCompatActivity {

    //This is an Activity opened from the navigation drawer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        // starts variable object
        RatingBar ratingbar = (RatingBar) findViewById(R.id.fivestars);
      /* Not needed in this cases
        String rating=String.valueOf(ratingbar.getRating());
            Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();

       */
    }
    //method that calls MainActivity screen
    public void sendMessage(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}