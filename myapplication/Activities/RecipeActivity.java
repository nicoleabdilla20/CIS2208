package com.example.myapplication.Activities;

import android.content.Intent;;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.UI.TabAdapter;
import com.example.myapplication.Fragments.RecipesFragment;
import com.example.myapplication.Fragments.Tab1;
import com.example.myapplication.Fragments.Tab2;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

public class RecipeActivity extends AppCompatActivity {

    //Variables
    private TextView mRecipeName;
    private TextView mRecipeCalorie;
    private TextView mRecipeIngredients;
    private TextView mRecipeMethodTitle;
    private TextView mRecipe;
    private ImageView mImage;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabAdapter adapter;
    private RecipesFragment frag2;

    //onCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_recipes);
        //definined the varibales
        mRecipeName = (TextView)findViewById(R.id.text_recipe);
        mRecipeCalorie = (TextView)findViewById(R.id.calorie_text);
        String Calorie = getIntent().getExtras().getString("RecipeCalorie");
        String Title = getIntent().getExtras().getString("RecipeName");
        mRecipeCalorie.setText(Calorie);
        mRecipeName.setText(Title);
        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        //fragments for tab pages
        frag2 = new RecipesFragment();
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1(), "Ingredients");
        adapter.addFragment(new Tab2(), "Instructions");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    // sendMessage method
    public void sendMessage(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


}
