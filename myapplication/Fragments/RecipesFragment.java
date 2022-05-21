package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RecipesFragment extends Fragment {
    private FloatingActionButton btn;


    public RecipesFragment() {
        // Required empty public constructor
    }

    //method about fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);
        //floatbtn();
        return view;
    }

    //method about button
    public void floatbtn(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ingredients Added", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}