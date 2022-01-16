package com.example.dramamultibahasa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dramamultibahasa.model.Comedy;
import com.example.dramamultibahasa.model.Drama;
import com.example.dramamultibahasa.model.Fantasy;
import com.example.dramamultibahasa.model.Romance;

public class RincianDramaActivity extends AppCompatActivity {

    Drama drama;
    TextView txGenre,txJudul,txSinopsis,txTahun;
    ImageView ivFotoDrama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rincian_drama);
        Intent intent = getIntent();
        drama = (Drama) intent.getSerializableExtra(DaftarDramaActivity.DRAMA_TERPILIH);
        inisialisasiView();
        tampilkanRincianDrama(drama);
    }

    private void inisialisasiView() {
        txGenre = findViewById(R.id.txGenre);
        txJudul = findViewById(R.id.txJudul);
        txTahun = findViewById(R.id.txTahun);
        txSinopsis = findViewById(R.id.txSinopsis);
        ivFotoDrama = findViewById(R.id.gambarDrama);
    }

    private void tampilkanRincianDrama(Drama drama) {
       Log.d("Rincian","Drama "+drama.getGenre());
        if(drama instanceof Comedy){
            txGenre.setText(R.string.Komedi);
        }else if(drama instanceof Romance) {
            txGenre.setText(R.string.Romantis);
        }else if(drama instanceof Fantasy) {
            txGenre.setText(R.string.Fantasi);
        }
        txJudul.setText(drama.getJudul());
        txTahun.setText(drama.getTahun());
        txSinopsis.setText(drama.getSinopsis());
        ivFotoDrama.setImageDrawable(this.getDrawable(drama.getDrawableRes()));
    }




}
