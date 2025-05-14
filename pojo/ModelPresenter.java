package com.example.myproject.pojo;

import android.content.Context;
import android.content.SharedPreferences;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import  com.example.myproject.ui.interfacePresnter;
public class ModelPresenter {
    private DBManager dbManager;
    private Context context;

    public ModelPresenter(Context context) {
        this.context = context;
        dbManager = new DBManager(context);
        dbManager.open();
    }

    public boolean checkUser(String email, String password) {
        try {
            return dbManager.checkAccount(email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addAccount(String userName, String emailAddress, String password, String phone) {
        try {
            return dbManager.insert(userName, emailAddress, password, phone);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }


    }

