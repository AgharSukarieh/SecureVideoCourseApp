package com.example.myproject.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myproject.R;

public class Login_Regster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_regster);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button create_button = findViewById(R.id.button_createAccount);
        Button login_button = findViewById(R.id.button_login);
      login_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginUser.class);
            startActivity(intent);
        });
      create_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, RigsterUser.class);
            startActivity(intent);
      });
        create_button.setBackgroundColor(Color.parseColor("#F05A2B"));
        login_button.setBackgroundColor(Color.parseColor("#DE58D75E"));


    }
}