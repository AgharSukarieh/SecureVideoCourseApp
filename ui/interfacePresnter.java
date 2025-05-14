package com.example.myproject.ui;

public interface interfacePresnter {
    void onLoginSuccess(String message, boolean status);
    void onAddSuccess(String message , boolean status);
    void onAddFailed(String message);
    void onLoginFailed(String message);
    void onsetSharedPreferences(String emailp, String passwordp);
}
