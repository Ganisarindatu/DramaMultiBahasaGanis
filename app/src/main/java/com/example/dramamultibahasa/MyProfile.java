package com.example.dramamultibahasa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MyProfile extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Galleri";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);
    }
}