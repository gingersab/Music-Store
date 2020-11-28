/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextgate.assesment.datatypes;

/**
 * A basic data structure representing a song.
 *
 * TODO: Add fields based on the given data
 *
 * @author nextgate.employee
 */
public class Song {

    private String title;
    private int rating;

    /**
     * Primary constructor.
     *
     * @param title the song title
     */
    public Song(String title) {
        this.title = title;
    }

    /**
     * Secondary constructor.
     *
     * @param title the song title
     * @param rating the rating of the song
     */
    public Song(String title, int rating) {
        this(title);
        this.rating = rating;
    }

    /**
     * @return the song title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the song title
     * @return this
     */
    public Song setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * @return the song rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the song rating
     * @return this
     */
    public Song setRating(int rating) {
        this.rating = rating;
        return this;
    }

}
