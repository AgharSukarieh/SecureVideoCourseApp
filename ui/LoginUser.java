package com.example.myproject.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myproject.R;
import com.example.myproject.pojo.Presenter;
import com.example.myproject.pojo.ModelPresenter;
import com.bumptech.glide.Glide;

public class LoginUser extends AppCompatActivity implements interfacePresnter {

    private EditText email, password;
    private Presenter presenter;
    private Button login;
    private TextView register, forgetPassword;
    private CheckBox rememberCheck;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);

        setupWindowInsets();
        initializeViews();
        setupPresenter();
        setupListeners();
        loadSavedCredentials();
        forimage();
    }
public void forimage()
{

     imageView = findViewById(R.id.image_login_gif);
    Glide.with(this).load(R.drawable.sayhi).into(imageView);
    login.setBackgroundColor(Color.parseColor("#DE58D75E"));

}
    private void setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initializeViews() {
        email = findViewById(R.id.emailUser);
        password = findViewById(R.id.passwordUser);
        login = findViewById(R.id.entry);
        rememberCheck = findViewById(R.id.rememberChick);
        forgetPassword = findViewById(R.id.forgetPassword);
    }

    private void setupPresenter() {
        presenter = new Presenter(this, new ModelPresenter(this));
    }

    private void setupListeners() {
        login.setOnClickListener(view -> handleLogin());
        forgetPassword.setOnClickListener(view -> navigateToForgetPassword());
    }

    private void handleLogin() {
        String emailUser = email.getText().toString().trim();
        String passwordUser = presenter.encryptionPassword(password.getText().toString().trim());

        if (emailUser.isEmpty() || passwordUser.isEmpty()) {
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rememberCheck.isChecked()) {
            saveCredentials(emailUser, password.getText().toString().trim());
        }

        presenter.login(emailUser, passwordUser);
    }

    private void saveCredentials(String emailUser, String passwordUser) {
        SharedPreferences sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", emailUser);
        editor.putString("password", passwordUser);
        editor.apply();
    }

    private void loadSavedCredentials() {
        SharedPreferences sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
        String savedEmail = sharedPreferences.getString("email", "");
        String savedPassword = sharedPreferences.getString("password", "");

        if (!savedEmail.isEmpty() && !savedPassword.isEmpty()) {
            email.setText(savedEmail);
            password.setText(savedPassword);
            rememberCheck.setChecked(true);
        }
    }



    private void navigateToForgetPassword() {
        Intent intent = new Intent(this, Forget_Password.class);
        startActivity(intent);
    }

    @Override
    public void onLoginSuccess(String message, boolean status) {
        if (status) {
            Intent intent = new Intent(this, MainActivityApp.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoginFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddSuccess(String message, boolean status) {
    }

    @Override
    public void onAddFailed(String message) {
    }

    @Override
    public void onsetSharedPreferences(String email, String password) {
    }
}
