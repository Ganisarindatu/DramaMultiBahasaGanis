package com.example.dramamultibahasa.model;
import java.io.Serializable;

public class Drama implements Serializable{
    private String judul;
    private String genre;
    private String tahun;
    private String sinopsis;
    private int drawableRes;

    public Drama(String genre, String judul, String tahun, String sinopsis, int drawableRes) {
        this.genre = genre;
        this.judul = judul;
        this.tahun = tahun;
        this.sinopsis = sinopsis;
        this.drawableRes = drawableRes;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre)
    {

        this.genre = genre;
    }

    public String getJudul() {

        return judul;
    }

    public void setJudul(String judul) {

        this.judul = judul;
    }

    public String getTahun() {

        return tahun;
    }

    public void setTahun(String tahun) {

        this.tahun = tahun;
    }

    public String getSinopsis() {

        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {

        this.sinopsis = sinopsis;
    }

    public int getDrawableRes() {

        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {

        this.drawableRes = drawableRes;
    }
}

