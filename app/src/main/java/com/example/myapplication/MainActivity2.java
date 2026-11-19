package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        Button buildingsButton = findViewById(R.id.buildingsbutton);
        if (buildingsButton != null) {
            buildingsButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            });
        }

        Button roomButton = findViewById(R.id.roombutton);
        if (roomButton != null) {
            roomButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            });
        }

        Button classButton = findViewById(R.id.classbutton);
        if (classButton != null) {
            classButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            });
        }

        Button announcementsButton = findViewById(R.id.announcementsbutton);
        if (announcementsButton != null) {
            announcementsButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
                startActivity(intent);
            });
        }

        Button stockButton = findViewById(R.id.Stockbutton);
        if (stockButton != null) {
            stockButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity2.this, MainActivity7.class);
                startActivity(intent);
            });
        }

        Button emergencyButton = findViewById(R.id.Emergnecybutton);
        if (emergencyButton != null) {
            emergencyButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity2.this, MainActivity16.class);
                startActivity(intent);
            });
        }

        Button mapButton = findViewById(R.id.Mapbutton);
        if (mapButton != null) {
            mapButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity2.this, MainActivity17.class);
                startActivity(intent);
            });
        }
    }
}

