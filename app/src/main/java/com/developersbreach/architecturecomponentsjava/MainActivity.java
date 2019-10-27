package com.developersbreach.architecturecomponentsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NavController mNavigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, mNavigationController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return mNavigationController.navigateUp();
    }
}
