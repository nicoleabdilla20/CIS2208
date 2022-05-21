package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Data.Database;
import com.example.myapplication.R;
public class ForgotPassword extends AppCompatActivity {
    Database DB;
    EditText regEmail, regPassword;
    Button c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        DB = new Database(this);
        regEmail = findViewById(R.id.edemail2);
        regPassword = findViewById(R.id.edpass2);
        c = findViewById(R.id.confirm);
       c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //defining the variables
                String email = regEmail.getText().toString();
                String pass = regPassword.getText().toString();
                //checking the box
                if(email.equals("")||pass.equals("")) {
                    toastMessage("Please enter all the fields");
                }
                else{
                    AddData(email, pass);
                }
            }
        });

    }

// add data to database
    public void AddData(  String e, String p) {
        boolean iD = DB.insertData2( e, p);
        if (iD) {
            toastMessage("Data Successfully Inserted!");
            loginIntent();
        } else {
            toastMessage("Something went wrong");
        }
    }

    //this method is the activity screen
    public void loginIntent(){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }
    // this method was used since an error was being raised when used in certain context
    //This resolved it.
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}