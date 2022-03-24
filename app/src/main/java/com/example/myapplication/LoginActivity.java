package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView login = (TextView) findViewById(R.id.login);
        TextView haslo = (TextView) findViewById(R.id.haslo);


        MaterialButton przycisk_login = (MaterialButton) findViewById(R.id.przycisk_login);


        przycisk_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login.getText().toString().equals("admin") && haslo.getText().toString().equals("admin")) {
                    Toast.makeText(LoginActivity.this, "LOGOWANIE POWIODLO SIE", Toast.LENGTH_SHORT).show();
                    openMainActivity();
                } else
                    Toast.makeText(LoginActivity.this, "LOGOWANIE NIE POWIODLO SIE", Toast.LENGTH_SHORT).show();
            }
        });

        }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}


