package com.example.dramamultibahasa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dramamultibahasa.model.Drama;

import java.util.List;

public class DaftarDramaAdapter extends ArrayAdapter<Drama> {

    Context context;

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
            viewHolder.textGenre =  convertView.findViewById(R.id.row_text_genre);
            viewHolder.textJudul = (TextView) convertView.findViewById(R.id.row_text_judul);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_drama);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textJudul.setText(drama.getJudul());
        viewHolder.textGenre.setText(drama.getGenre());
        viewHolder.gambar.setImageDrawable(context.getDrawable(drama.getDrawableRes()));
        return convertView;
    }

}