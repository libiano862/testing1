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

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new DatabaseHelper(this);

        // Pre-populate a default user if none exists
        if (!dbHelper.checkUsernameExists("Libby")) {
            // Notice: ID is omitted when creating a new user (SQLite autoincrements the ID)
            User adminUser = new User("Libby", "Libby123", "Admin");
            dbHelper.addUser(adminUser);
        }

        usernameEditText = findViewById(R.id.editTextTextEmailAddress3);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        Button move = findViewById(R.id.Move);

        if (move != null) {
            move.setOnClickListener(v -> {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please enter your username and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = dbHelper.checkUser(username, password);
                if (user != null) {
                    Toast.makeText(MainActivity.this, "Welcome " + user.getUsername(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button registerButton = findViewById(R.id.Register);
        if (registerButton != null) {
            registerButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, MainActivity19.class);
                startActivity(intent);
            });
        }
    }
}
