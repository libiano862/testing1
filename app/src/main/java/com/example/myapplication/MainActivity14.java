package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityMain14Binding;

public class MainActivity14 extends AppCompatActivity {

    private Button EndButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMain14Binding binding = ActivityMain14Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.returnbutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity14.this, MainActivity3.class);
            startActivity(intent);
        });

        EndButton = findViewById(R.id.Endbutton);
        EndButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity14.this, MainActivity18.class);
            startActivity(intent);
        });
    }
}