package com.example.dramamultibahasa;

import android.content.Context;

import com.example.dramamultibahasa.model.Drama;
import com.example.dramamultibahasa.model.Comedy;
import com.example.dramamultibahasa.model.Fantasy;
import com.example.dramamultibahasa.model.Romance;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Drama> dramas = new ArrayList<>();

    private static List<Romance> initDataRomance(Context ctx) {
        List<Romance> romances = new ArrayList<>();
        romances.add(new Romance(ctx.getString(R.string.cloy_judul), ctx.getString(R.string.cloy_date),
                ctx.getString(R.string.cloy_sinopsis), R.drawable.cloy));

        romances.add(new Romance(ctx.getString(R.string.swp_judul), ctx.getString(R.string.swp_date),
                ctx.getString(R.string.swp_sinopsis), R.drawable.swp));

        romances.add(new Romance(ctx.getString(R.string.gbc_judul), ctx.getString(R.string.gbc_date),
                ctx.getString(R.string.gbc_sinopsis), R.drawable.gbc));

        romances.add(new Romance(ctx.getString(R.string.ffmw_judul), ctx.getString(R.string.ffmw_date),
                ctx.getString(R.string.ffmw_sinopsis), R.drawable.ffmw));
        return romances;
    }

    private static List<Comedy> initDataComedy(Context ctx) {
        List<Comedy> comedies = new ArrayList<>();
        comedies.add(new Comedy(ctx.getString(R.string.swdbs_judul), ctx.getString(R.string.swdbs_date),
                ctx.getString(R.string.swdbs_sinopsis), R.drawable.swdbs));
        comedies.add(new Comedy(ctx.getString(R.string.mrqueen_judul), ctx.getString(R.string.mrqueen_date),
                ctx.getString(R.string.mrqueen_sinopsis), R.drawable.mrq));
        comedies.add(new Comedy(ctx.getString(R.string.tbm_judul), ctx.getString(R.string.tbm_date),
                ctx.getString(R.string.tbm_sinopsis), R.drawable.tbm));
        comedies.add(new Comedy(ctx.getString(R.string.swdbs_judul),ctx.getString(R.string.waikiki_date),ctx.getString(R.string.waikiki_sinopsis),R.drawable.waikiki));
        return comedies;
    }

    private static List<Fantasy> initDataFantasy(Context ctx) {
        List<Fantasy> fantasies = new ArrayList<>();
        fantasies.add(new Fantasy(ctx.getString(R.string.days_judul), ctx.getString(R.string.days_date),
                ctx.getString(R.string.days_sinopsis), R.drawable.days));
        fantasies.add(new Fantasy(ctx.getString(R.string.mota_judul), ctx.getString(R.string.mota_date),
                ctx.getString(R.string.mota_sinopsis), R.drawable.mota));
        fantasies.add(new Fantasy(ctx.getString(R.string.hslo_judul), ctx.getString(R.string.hslo_date),
                ctx.getString(R.string.hslo_sinopsis), R.drawable.hslo));
        fantasies.add(new Fantasy(ctx.getString(R.string.moorim_judul), ctx.getString(R.string.moorim_date),
                ctx.getString(R.string.moorim_sinopsis), R.drawable.mschool));
               return fantasies;
    }

    private static void initAllDramas(Context ctx) {
        dramas.addAll(initDataComedy(ctx));
        dramas.addAll(initDataRomance(ctx));
        dramas.addAll(initDataFantasy(ctx));
    }

    public static List<Drama> getAllDrama(Context ctx) {
        if (dramas.size() == 0) {
            initAllDramas(ctx);
        }
        return dramas;
    }

    public static List<Drama> getDramaByGenre(Context ctx, String genre) {
        List<Drama> dramasByGenre = new ArrayList<>();
        if (dramas.size() == 0) {
            initAllDramas(ctx);
        }
        for (Drama d : dramas) {
            if ((d.getGenre().equals(genre))) {
                dramasByGenre.add(d);
            }
        }
        return dramasByGenre;
    }

}
