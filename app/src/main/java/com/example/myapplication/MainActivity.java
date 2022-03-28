package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity
{
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem)
            {
                Log.d("TAG", "onNavigationItemSelected: " + menuItem.getItemId());

                switch (menuItem.getItemId())
                {
                    case R.id.nav_logout:
                        addFragment();
                        break;

                    default:
                        break;
                }


                drawer.close();
                return false;
            }
        });
//         ClientHttp clientHttp = new ClientHttp();
//         clientHttp.login("","");


    }

    private void addFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
               // .addToBackStack(null)
                .commit();
    }


}