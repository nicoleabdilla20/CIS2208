package com.example.myapplication.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;


public class MeFragment extends Fragment {

    // Object Variables
    Button btnsubmit;
    EditText addcal,addfat,addcarb, weight;
    TextView tv;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        btnsubmit=view.findViewById(R.id.click);
        tv=view.findViewById(R.id.display);
        tv.setMovementMethod(new ScrollingMovementMethod());
        btnsubmit.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                addcal=view.findViewById(R.id.mycal);
                addfat=view.findViewById(R.id.myfat);
                addcarb=view.findViewById(R.id.mycarb);
                weight  = view.findViewById(R.id.myweight);
                // outout details
                tv.setText(addcal.getText().toString()
                        +"\tCalories\n"
                        +addfat.getText().toString()
                        +"\tFat\n"
                        +addcarb.getText().toString()
                        +"\tCarbs\n"
                        +weight.getText().toString()
                        +"\tWeight\n");
            }
        });
        return view;
    }
}