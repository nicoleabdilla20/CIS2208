package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Data.Database;
import com.example.myapplication.R;

public class SignUp extends AppCompatActivity {

    //variables
    EditText regEmail, regPassword, regFullname;
    Button regConfirm, regEnter;
    CheckBox check;
    Database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // variables are declared
        regEmail = findViewById(R.id.inpemail);
        regPassword = findViewById(R.id.inppass);
        DB = new Database(this);
        regFullname = findViewById(R.id.inpname);
        regConfirm = findViewById(R.id.confirm);
        regEnter = findViewById(R.id.enter);
        check =(CheckBox)findViewById(R.id.checkbox);

        //the below enters thhe registration
        regConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = regFullname.getText().toString();
                    String email = regEmail.getText().toString();
                    String pass = regPassword.getText().toString();
                    //checking the box
                    if (check.isChecked()) {
                        check.setChecked(true);
                    }
                    //if loop checks that fields are not left empty
                    if(name.equals("")||email.equals("")||pass.equals("")) {
                        toastMessage("Please enter all the fields");
                    }
                    else{
                        boolean check_em = DB.check_email(email);
                        if (check_em == false) {
                            AddData(name, email, pass);
                        } else {
                            toastMessage("User already exists! please sign in");
                        }
                    }
                }
            });
    }
    //method for the login activity
    public void loginIntent(){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

    //method to input data successfully
    public void AddData(String n, String e, String p) {
        boolean iD = DB.insertData(n, e, p);
        if (iD) {
            toastMessage("Data Successfully Inserted!"); //outputs message
            loginIntent(); //outputs activity
        } else {
            toastMessage("Something went wrong"); //outputs message
        }
    }

    // method to display bottom messagr
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
