package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Activities.MainActivity;
import com.example.myapplication.Activities.PopUpActivity;
import com.example.myapplication.R;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        //object to show pop up
        ImageButton popupButton = findViewById(R.id.buttonPopup);
        popupButton.setOnClickListener(new View.OnClickListener() {
            //on click on image button method
            @Override
            public void onClick(View v) {
                // the popupactivy object
                PopUpActivity popUpClass = new PopUpActivity();
                popUpClass.showPopupWindow(v);
            }
        });
    }

    public void sendMessage(View view) {
        //Using Intents
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }
}