package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Activities.MainActivity;
import com.example.myapplication.Data.Database;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Login extends AppCompatActivity{
    // Variables
    EditText regEmail, regPassword;
    Button btnEnter, forgot;
    Database DB;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //vriables are set and declared
        regEmail = findViewById(R.id.edemail);
        regPassword = findViewById(R.id.edpass);
        //database is declared
        DB = new Database(this);
        btnEnter = findViewById(R.id.enter);
        forgot = findViewById(R.id.text2);

        TextView linkTextView = findViewById(R.id.text2);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = regEmail.getText().toString();
                String pass = regPassword.getText().toString();
                //if loop to check if fields are left empty
                if(email.equals("")||pass.equals("")) {
                    toastMessage2("Please enter all the field");
                }
                else {
                    validation(email, pass);
                }
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              ForgetloginIntent();
            }
        });
    }

    public void loginIntent(){
        //FragmentManager fm = getSupportFragmentManager();
       // fm.beginTransaction().add(R.id.contaner,new Page1()).commit();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void ForgetloginIntent(){
        //FragmentManager fm = getSupportFragmentManager();
        // fm.beginTransaction().add(R.id.contaner,new Page1()).commit();
        Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
        startActivity(intent);
    }

    //method to display bottom messages
    private void toastMessage2(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    //validation check to make sure no duplicate accounts are created
    public void validation(String e, String p) {
        boolean check = DB.check_email_password(e, p);
        if (check) {
            toastMessage2("Successfully!");
            loginIntent();
        } else {
            toastMessage2("Something went wrong");
        }
    }
}