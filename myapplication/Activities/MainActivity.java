package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Fragments.GroceryFragment;
import com.example.myapplication.Fragments.MeFragment;
import com.example.myapplication.Fragments.RecipesFragment;
import com.example.myapplication.Models.Recipes;
import com.example.myapplication.Activities.Account;
import com.example.myapplication.R;
import com.example.myapplication.UI.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    RecyclerView myrecyclerView;
    RecyclerViewAdapter myAdapter;
    Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    List<Recipes> recipes1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recipes();
        toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
        //calling public methods
        action();
        bottom();

    }
    //manually inputting recipe details into ArrayList
    //not ideal code
    public void recipes() {
        recipes1 = new ArrayList<>();
        recipes1.add(new Recipes("Green Tea Noodles", "120 calories", "125ml peanut oil\n" +
                "1 tbs finely chopped ginger\n" +
                "1 ½ tbs runny honey\n" +
                "3 long green shallots, thinly sliced\n" +
                "1 lemongrass stalk (white part only), finely grated\n " +
                "2 tbs extra virgin olive oil\n" +
                "80g chilli paste in soybean oil\n" +
                "600g whole skinless salmon fillet, pin-boned\n" +
                "240g packet dried green tea noodles\n " +
                "⅓ lime juice\n" +
                "2 ½ tsp caster sugar\n" +
                "2 tsp fish sauce\n" + "½ tsp chilli flakes, plus extra to serve\n", "Method",
                "1.\tPreheat oven to 220°C. Heat peanut oil in a small saucepan over low heat. Add ginger, long green shallot, lemongrass and a pinch of salt. Cook, stirring occasionally, for 6-8 minutes until long green shallot is very soft but not coloured. Remove from heat and cool.\n"
                        + "2.\tMeanwhile, combine honey, olive oil and chilli paste in a bowl. Stir to combine. Line a baking tray with baking paper and add salmon. Rub honey mixture over salmon to coat, then season. Roast for 12-15 minutes for medium. Set aside, loosely covered with foil, to rest for 5 minutes."
                + "3.\tCook noodles according to packet instructions. Drain and rinse briefly with warm water.\n"
                + "4.\tWhisk lime juice, sugar, fish sauce and chilli flakes into the shallot oil mixture. Place noodles in a large bowl with three quarters of the shallot oil, season and toss to combine. Arrange on a serving platter and flake salmon over the top. Drizzle over remaining shallot oil and scatter with extra chilli flakes, toasted sesame seeds and shiso leaves. Serve at room temperature or chilled.", R.drawable.green_tea_noodles_with_sticky_sweet_chilli_salmon_140868_2));


        recipes1.add(new Recipes("Donut", "452 calories", "1 c. whole milk" +
                "1/4 c. plus 1 tsp. granulated sugar, divided" +
                "1 packet (or 2 1/4 tsp.) active dry yeast " +
                "4 c. all-purpose flour, plus more if needed" +
                "1/2 tsp. kosher salt" +
                "6 tbsp. melted butter" +
                "2 large eggs" +
                "1/2 tsp. pure vanilla extract" +
                "Canola or vegetable oil, for frying", "Method", "\n" +
                "Grease a large bowl with cooking spray and set aside. In a small, microwave-safe bowl or glass measuring cup, add milk. Microwave until lukewarm, 40 seconds. Add a teaspoon of sugar and stir to dissolve, then sprinkle over yeast and let sit until frothy, about 8 minutes.\n" +
                "Make glaze: In a large bowl, whisk together milk, powdered sugar, and vanilla until smooth. Set aside.\n" +
                "Line a large baking sheet with paper towels. In a large dutch oven over medium heat, heat 2'' oil to 350°. Cook doughnuts, in batches, until deeply golden on both sides, about 1 minute per side. Holes will cook even faster!\n" +
                "Transfer doughnuts to paper towel-lined baking sheet to drain and cool slightly. Dip into glaze, then place onto a cooling rack (or eat immediately!)", R.drawable.donut));
        recipes1.add(new Recipes("Dosa", "20 calories", "3 cups rice" +
                "1 cup urad daal (split, skinless black gram)" +
                "3/4 teaspoon fenugreek seeds" +
                "Salt (to taste)" +
                "Vegetable / canola / sunflower cooking oil", "Method",
                "Wash the rice and urad daal well. Add the fenugreek seeds to the mix and fill enough water in the rice-daal bowl to cover them about 2-inch deep. Soak overnight.\n" +
                        "Put some cooking oil in a small bowl and keep ready. You will also need a bowl of ice cold water, a large, flat nonstick pan, 2 sheets of paper towel, a ladle, a spatula, and a basting brush.\n" +
                        "When the upper surface begins to look cooked (it will no longer look soft or runny), flip the dosa. By this time, ideally, the surface that was underneath should be light golden in color. Cook for 1 minute after flipping.\n" +
                        "The dosa is almost done. Fold it in half and allow to cook for 30 seconds more.", R.drawable.dosa));
        recipes1.add(new Recipes("Pancake", "20 calories", "1 1/4 cups milk" +
                "1 egg" +
                "3 tablespoons butter melted" +
                "1 1/2 cups all-purpose flour" +
                "3 1/2 teaspoons baking powder" +
                "1 teaspoon salt" +
                "1 tablespoon white sugar", "Method",
                "In a large bowl, sift together the flour, baking powder, salt and sugar. Make a well in the center and pour in the milk, egg and melted butter; mix until smooth." +
                        "Heat a lightly oiled griddle or frying pan over medium high heat. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake. Brown on both sides and serve hot.", R.drawable.pancake));
        recipes1.add(new Recipes("Pasta", "20 calories", "1 tsp oil" +
                "1 tsp butter" +
                "2 clove garlic, finely chopped" +
                "1 inch ginger, finely chopped" +
                "½ onion, finely chopped" +
                "1 cup tomato pulp" +
                "¼ tsp turmeric / haldi" +
                "½ tsp kashmiri red chilli powder" +
                "2 tbsp tomato sauce" +
                "½ tsp garam masala", "Method",
                "firstly, saute 1 inch ginger and 2 clove garlic in 1 tsp oil and 1 tsp butter." +
                        "further saute ½ onion till they turn soft." +
                        "additionally add 1 cup tomato pulp and saute well." +
                        "keep stirring till the tomato pulp thickens." +
                        "now add ¼ tsp turmeric, ½ tsp chilli powder, ½ tsp garam masala and ½ tsp salt." +
                        "saute till the spices gets cooked completely." +
                        "now add 2 tbsp corn, ¼ capsicum, ¼ carrot, 2 tbsp peas and 7 florets broccoli. saute for a minute." +
                        "add in 3 tbsp water and mix well." +
                        "cover and simmer for 5 minutes." +
                        "now add in 2 tbsp tomato sauce and ½ tsp mixed herbs. mix well." +
                        "add in cooked pasta and mix gently till the sauce gets coated well." +
                        "finally, serve masala pasta indian style hot topped with cheese if required.", R.drawable.pasta));


        myrecyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);
        myAdapter = new RecyclerViewAdapter(this, recipes1);
        myrecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        myrecyclerView.setAdapter(myAdapter);

    }

    //method for bottom naviagation to call fragments according to page selection
    public void bottom() {
        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        BottomNavigationView.OnNavigationItemSelectedListener navListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.page_1:
                                selectedFragment = new MeFragment();
                                break;
                            case R.id.page_2:
                               selectedFragment = new RecipesFragment();
                                break;
                            case R.id.page_3:
                               selectedFragment = new GroceryFragment();
                                break;
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cont,
                                selectedFragment).commit();
                        return true;
                    }
                };
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    //method for drawer naviagation

    public void action() {
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }

    //method to open the activit according to selection pressed from navigation drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            Intent intent = new Intent(getApplicationContext(), Settings.class);
            startActivity(intent);

        } else if (id == R.id.item2) {
            Intent intent = new Intent(getApplicationContext(), About.class);
            startActivity(intent);

        } else if (id == R.id.item3) {
            Intent intent = new Intent(getApplicationContext(), Feedback.class);
            startActivity(intent);

        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // methods to control the operations that will
    // happen when user clicks on the action buttons
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.account:
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
                Toast.makeText(this, "Account Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
