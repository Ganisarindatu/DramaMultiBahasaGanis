package com.example.dramamultibahasa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dramamultibahasa.model.Comedy;
import com.example.dramamultibahasa.model.Drama;
import com.example.dramamultibahasa.model.Fantasy;
import com.example.dramamultibahasa.model.Romance;

import java.util.List;

public class DaftarDramaAdapter extends ArrayAdapter<Drama> {

    Context context;
    TextView textRowGenre;

    public DaftarDramaAdapter(Context context, List<Drama> dramas) {
        super(context, R.layout.row_daftar_drama, dramas);
        this.context = context;
    }

    private static class ViewHolder  {
        TextView textGenre;
        TextView textJudul;
        ImageView gambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Drama drama = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_drama, parent, false);
            viewHolder.textGenre =  (TextView) convertView.findViewById(R.id.row_text_genre);
            viewHolder.textJudul = (TextView) convertView.findViewById(R.id.row_text_judul);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_drama);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        textRowGenre = convertView.findViewById(R.id.row_text_genre);

        viewHolder.textJudul.setText(drama.getJudul());
        tampilkanGenre(drama);
        viewHolder.gambar.setImageDrawable(context.getDrawable(drama.getDrawableRes()));
        return convertView;
    }

    private void tampilkanGenre(Drama drama){
        if(drama instanceof Comedy){
            textRowGenre.setText(R.string.Komedi);
        }else if(drama instanceof Romance) {
            textRowGenre.setText(R.string.Romantis);
        }else if(drama instanceof Fantasy) {
            textRowGenre.setText(R.string.Fantasi);
        }
    }
}