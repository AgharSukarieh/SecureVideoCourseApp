package com.example.myproject.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.myproject.pojo.ModelPresenter;
import com.example.myproject.pojo.Presenter;
import com.example.myproject.R;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import com.bumptech.glide.Glide;

public class RigsterUser extends AppCompatActivity implements interfacePresnter {
    Button register , clear;
    ImageView imageView;
    EditText username, userphone, useremail, userpassword, userconfirmpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.rigister_user);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Presenter presenter = new Presenter(this, new ModelPresenter(this));
        username = findViewById(R.id.username);
        useremail = findViewById(R.id.useremail);
        userphone = findViewById(R.id.userphone);
        userpassword = findViewById(R.id.userpassword);
        userconfirmpassword = findViewById(R.id.passwordUserConfirm);

        register = findViewById(R.id.createAccount);

        register.setOnClickListener(v -> {
            String usernameUser = username.getText().toString();
            String useremailUser = useremail.getText().toString();
            String userphoneUser = userphone.getText().toString();

            String encryptionUserConfirmPassword = presenter.encryptionPassword(userconfirmpassword.getText().toString());
            String encryptionPasswordWord = presenter.encryptionPassword(userpassword.getText().toString());


            if (usernameUser.isEmpty() || useremailUser.isEmpty() || userphoneUser.isEmpty() ||
                    encryptionPasswordWord.isEmpty() || encryptionUserConfirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else if (!encryptionPasswordWord.equals(encryptionUserConfirmPassword)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                Executor executor = Executors.newSingleThreadExecutor();
                executor.execute(() -> {
                   presenter.register(usernameUser, useremailUser, encryptionPasswordWord, userphoneUser);


                });
            }
        });
        clear = findViewById(R.id.clear_edit_text);
        clear.setOnClickListener(v -> {
            username.setText("");
            useremail.setText("");
            userphone.setText("");
            userpassword.setText("");
            userconfirmpassword.setText("");
        });

        forimage();
    }
    public void forimage()
    {

        imageView = findViewById(R.id.image_login_gif);
        Glide.with(this).load(R.drawable.sayhi).into(imageView);
        register.setBackgroundColor(Color.parseColor("#F05A2B"));
        clear.setBackgroundColor(Color.parseColor("#DE58D75E"));
    }

    @Override
    public void onLoginSuccess(String message, boolean status) {
    }

    @Override
    public void onAddSuccess(String message, boolean status) {
        if (status){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        finish();}
        else{
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onAddFailed(String message) {
    }

    @Override
    public void onLoginFailed(String message) {
    }
    @Override
    public void onsetSharedPreferences(String email, String password) {
    }
}
