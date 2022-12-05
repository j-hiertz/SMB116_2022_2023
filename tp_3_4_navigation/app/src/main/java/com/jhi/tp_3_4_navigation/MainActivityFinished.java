package com.jhi.tp_3_4_navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

@SuppressWarnings("ALL")
public class MainActivityFinished extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView navView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeToolbar();
        initializeDrawerMenu();
        initializeBottomNavigationView();
    }

    private void initializeBottomNavigationView() {
        // 1 - Récupérer le BottomNavigationView du fichier layout
        // Permet de récupérer l'instance du NavHostFragment présent dans le FragmentContainerView du fichier layout
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        // 2 - Récupérer une instance de NavController depuis le NavHostFragment
        // 3 - Utiliser une méthode statique de NavigationUI pour faire le lien dans votre BottomNavigationView et le NavController
    }

    private void initializeDrawerMenu() {
        // Étape précédente
    }

    private void initializeToolbar() {
        // Étape précédente
    }
}