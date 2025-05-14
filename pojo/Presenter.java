package com.example.myproject.pojo;

import android.content.SharedPreferences;

import com.example.myproject.ui.interfacePresnter;

public class Presenter {
    private interfacePresnter inter;
    private ModelPresenter modelPresenter;

    public Presenter(interfacePresnter inter, ModelPresenter modelPresenter) {
        this.inter = inter;
        this.modelPresenter = modelPresenter;
    }


    public void login(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            inter.onLoginFailed("Please enter email and password");
        } else {
            boolean isUserValid = modelPresenter.checkUser(email, password);
            if (isUserValid) {
                inter.onLoginSuccess("Login Success", true);
            } else {
                inter.onLoginFailed("Login Invalid");
            }
        }
    }

    public void register(String userName, String emailAddress, String password, String phone) {
        boolean checkAdd = modelPresenter.addAccount(userName, emailAddress, password, phone);
        if (checkAdd) {
            inter.onAddSuccess("Register Success", true);
        } else {
            inter.onAddSuccess("Register Failed", false);
        }
    }
    public String encryptionPassword(String password){
        return modelPresenter.hashPassword(password);
    }

}
