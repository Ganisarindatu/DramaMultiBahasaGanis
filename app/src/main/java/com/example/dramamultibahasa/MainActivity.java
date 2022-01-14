package com.example.dramamultibahasa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton btnComedy,btnRomance,btnFantasy,btnProfile;
    public static final String GENRE_GALERI_KEY = "GENRE_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
        btnProfile = (ImageButton) findViewById(R.id.menujuProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadViewActivity = new Intent(MainActivity.this,MyProfile.class);
                startActivity(intentLoadViewActivity);
            }
        });
    }

    private void inisialisasiView() {
        btnComedy = findViewById(R.id.btn_drama_comedy);
        btnFantasy = findViewById(R.id.btn_drama_fantasy);
        btnRomance = findViewById(R.id.btn_drama_romance);
        btnComedy.setOnClickListener(view -> bukaGaleri("Comedy"));
        btnFantasy.setOnClickListener(view -> bukaGaleri("Fantasy"));
        btnRomance.setOnClickListener(view -> bukaGaleri("Romance"));
    }

    private void bukaGaleri(String genreDrama) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, DaftarDramaActivity.class);
        intent.putExtra(GENRE_GALERI_KEY, genreDrama);
        startActivity(intent);
    }

}