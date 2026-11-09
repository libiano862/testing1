package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buildingsButton = findViewById(R.id.buildingsbutton);
        buildingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });

        Button roomButton = findViewById(R.id.roombutton);
        roomButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
            startActivity(intent);

        });

        Button classButton = findViewById(R.id.classbutton);
        classButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
            startActivity(intent);
        });

        Button scheduleButton = findViewById(R.id.announcementsbutton);
        scheduleButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
            startActivity(intent);
        });
        
        Button contactButton = findViewById(R.id.Stockbutton);
        contactButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity7.class);
            startActivity(intent);
        });

        Button exitButton = findViewById(R.id.Emergnecybutton);
        exitButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity16.class);
            startActivity(intent);
        });

        Button mapButton = findViewById(R.id.Mapbutton);
        mapButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity17.class);
            startActivity(intent);
        });
    }
}
