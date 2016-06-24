package com.example_api3.mamani.my_only_exemple;

import android.media.Image;

/**
 * Created by mamani on 24/06/16.
 */
public class Movie {
    private String mVname;
    private int mVyear;
    private int rating;
    private int duration;
    private String director;
    private String tagline;
    private String[] cast;
    private Image image;
    private String story;




    Movie()
    {
        mVname ="";
        mVyear=0;
    }

    public int getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }

    public String getTagline() {
        return tagline;
    }

    public String[] getCast() {
        return cast;
    }

    public Image getImage() {
        return image;
    }

    public String getStory() {
        return story;
    }

    public String getmVname() {
        return mVname;
    }

    public int getmVyear() {
        return mVyear;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setmVname(String mVname) {
        this.mVname = mVname;
    }

    public void setmVyear(int mVyear) {
        this.mVyear = mVyear;
    }

    public String string_name_year()
    {
        return getmVname()+" - "+getmVyear()+"\n";
    }



}
