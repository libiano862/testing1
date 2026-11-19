package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityMain19Binding;

public class MainActivity19 extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMain19Binding binding = ActivityMain19Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new DatabaseHelper(this);

        usernameEditText = findViewById(R.id.editTextTextEmailAddress3);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        Button move1 = findViewById(R.id.Move1);

        if (move1 != null) {
            move1.setOnClickListener(v -> {
                String username = usernameEditText != null ? usernameEditText.getText().toString().trim() : "";
                String password = passwordEditText != null ? passwordEditText.getText().toString().trim() : "";

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity19.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (dbHelper.checkUsernameExists(username)) {
                    Toast.makeText(MainActivity19.this, "Username already exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                User newUser = new User(username, password, "User");
                long result = dbHelper.addUser(newUser);

                if (result != -1) {
                    Toast.makeText(MainActivity19.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity19.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity19.this, "Error creating account", Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button returnButton = findViewById(R.id.Return);
        if (returnButton != null) {
            returnButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity19.this, MainActivity.class);
                startActivity(intent);
            });
        }
    }
}
