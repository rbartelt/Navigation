package de.xxlstrandkorbverleih.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();                         //get NavController

        //set TopLevelDestinations (wich dont show the Backbutton in Actionbar)
        Set<Integer> topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.homeFragment);
        topLevelDestinations.add(R.id.searchFragment);
        //find DrawerLayout
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        //setup AppBarConfiguration
        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations).setOpenableLayout(drawerLayout).build();

        Toolbar toolbar = findViewById(R.id.toolbar);                               //find Toolbar
        setSupportActionBar(toolbar);                                               //set Toolbar as Actionbar in Mainactivity
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);   //connects the Toolbar with Navgraph

        //connects BottomNavigationView with NavGraph
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        //Connect Drawer with Navgraph
        NavigationView navigationView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.termsAndConditions) {
            NavDirections action = NavGraphDirections.actionGlobalTermsFragment();
            navController.navigate(action);
            return true;
        } else {
            return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}