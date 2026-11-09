package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button returnButton = findViewById(R.id.returnbutton);
        returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
            startActivity(intent);
        });

        Button ORTIZBUILDINGbutton = findViewById(R.id.ORTIZBUILDINGbutton);
        ORTIZBUILDINGbutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity8.class);
            startActivity(intent);
        });

        Button CARDINALJAIMESINBUILDINGbutton = findViewById(R.id.JAIMESINbutton);
        CARDINALJAIMESINBUILDINGbutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity9.class);
            startActivity(intent);
        });

        Button TAGLEBUILDINGbutton = findViewById(R.id.TAGLEBUILDINGbutton);
        TAGLEBUILDINGbutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity10.class);
            startActivity(intent);
        });

        Button ROBLESBUILDINGbutton = findViewById(R.id.ROSALESBUILDINGbutton);
        ROBLESBUILDINGbutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity11.class);
            startActivity(intent);
        });

        Button ODOHERTYBUILDINGbutton = findViewById(R.id.ODOHERTYBUILDINGbutton);
        ODOHERTYBUILDINGbutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity12.class);
            startActivity(intent);
        });

        Button ARCHBISHOPGABRIELbutton = findViewById(R.id.ARCHBISHOPGABRIELbutton);
        ARCHBISHOPGABRIELbutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity13.class);
            startActivity(intent);
        });

    }
}
