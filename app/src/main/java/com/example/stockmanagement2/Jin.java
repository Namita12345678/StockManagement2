package com.example.stockmanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;
import java.io.Serializable;

public class Jin implements Serializable {

    public static final String EXTRA ="com.example.stockmanagement2";


    String username, password;


    public Jin(){
    }


    public Jin(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}