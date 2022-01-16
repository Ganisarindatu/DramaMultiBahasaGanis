package com.example.dramamultibahasa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dramamultibahasa.model.Drama;
import com.example.dramamultibahasa.model.Comedy;
import com.example.dramamultibahasa.model.Fantasy;
import com.example.dramamultibahasa.model.Romance;

import java.util.List;

public class DaftarDramaActivity extends AppCompatActivity {
    public final static String DRAMA_TERPILIH ="drama_obj_key";
    List<Drama> dramas;
    ListView listView;
    String genreDrama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_drama);
        Intent intent = getIntent();
        genreDrama = intent.getStringExtra(com.example.dramamultibahasa.MainActivity.GENRE_GALERI_KEY);
        TextView txGenre = findViewById(R.id.text_title_daftar);
        txGenre.setText("Daftar Drama "+genreDrama.toUpperCase());
        dramas = DataProvider.getDramaByGenre(this,genreDrama);
        TextView txJudulList = findViewById(R.id.text_title_daftar);
        String judul="";
        if (dramas.get(0) instanceof Comedy) {
            judul = getString(R.string.komedi_list_title);
        } else if (dramas.get(0) instanceof Romance) {
            judul = getString(R.string.romantis_list_title);
        }
        else if (dramas.get(0) instanceof Fantasy){
            judul = getString(R.string.fantasi_list_title);
        }
        txJudulList.setText(judul);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_drama);
        com.example.dramamultibahasa.DaftarDramaAdapter adapter = new com.example.dramamultibahasa.DaftarDramaAdapter(this,dramas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Drama terpilih = dramas.get(position);
            bukaRincianDrama(terpilih);
        }
    };

    private void bukaRincianDrama(Drama dramaTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, com.example.dramamultibahasa.RincianDramaActivity.class);
        intent.putExtra(DRAMA_TERPILIH,dramaTerpilih);
        startActivity(intent);
    }


}