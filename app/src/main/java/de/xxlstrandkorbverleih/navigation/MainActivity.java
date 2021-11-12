package de.xxlstrandkorbverleih.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
        final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();                         //get NavController

        //set TopLevelDestinations
        Set<Integer> topLevel = new HashSet<>();
        topLevel.add(R.id.homeFragment);
        topLevel.add(R.id.searchFragment);
        //and set it to the AppBarConfiguration to avoid the Back Button shown in the actionBar
        appBarConfiguration = new AppBarConfiguration.Builder(topLevel).build();

        Toolbar toolbar = findViewById(R.id.toolbar);                               //find Toolbar
        setSupportActionBar(toolbar);                                               //set Toolbar as Actionbar in Mainactivity
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);   //connects the Toolbar with Navgraph

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);  //find BottomNavigationView
        NavigationUI.setupWithNavController(bottomNavigationView, navController);   //connects BottomNavigationView with NavGraph
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
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}