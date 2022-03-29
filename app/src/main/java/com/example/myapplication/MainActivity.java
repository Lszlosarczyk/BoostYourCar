package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_felgi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FelgiFragment()).commit();
                break;
            case R.id.nav_tuning_silnika:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TuningSilnikaFragment()).commit();
                break;
            case R.id.nav_tuning_zawieszenia:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TuningZawieszeniaFragment()).commit();
                break;
            case R.id.nav_tuning_wewnetrzny:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TuningWewnetrznyFragment()).commit();
                break;
            case R.id.nav_tuning_zewnetrzny:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TuningZewnetrznyFragment()).commit();
                break;
            case R.id.nav_kosmetyki_samochodowe:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new KosmetykiSamochodoweFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
               // .addToBackStack(null)
                .commit();
    }


}