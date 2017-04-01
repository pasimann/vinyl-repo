package com.pasimann.app.model;

public class SummaryItem {

    private String artist;
    private int count;

    public SummaryItem(String artist, int count) {
       this.artist = artist;
       this.count = count;
    }

    public String getArtist() {
       return artist;
    }

    public int getCount() {
       return count;
    }
}
