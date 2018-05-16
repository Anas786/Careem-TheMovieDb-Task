package com.example.anas.careemmoviedb.Model;

/**
 * Created by Anas on 15-May-18.
 */

public class MovieCardDataModel {
    private Float Popularity;
    private String MovieName;
    private String ImagePath;

    public MovieCardDataModel(Float popularity, String movieName, String imagePath){
        Popularity = popularity;
        MovieName = movieName;
        ImagePath = imagePath;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public Float getPopularity() {
        return Popularity;
    }

    public void setPopularity(Float popularity) {
        Popularity = popularity;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }
}
