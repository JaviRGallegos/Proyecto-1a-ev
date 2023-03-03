package com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Models;

import android.graphics.drawable.Drawable;

public class VideoGame {

    private String title;
    private String genre;



    private Drawable image;
    private String release_date;

    public VideoGame(String title, String genre, Drawable image, String release_date) {
        this.title = title;
        this.genre = genre;
        this.image = image;
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

}
