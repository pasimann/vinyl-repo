package com.pasimann.app.model;

public class StoreItem {

    private String artist;
    private String title;
    private String company;

    private int year;

    private String format;

    private boolean heavyweight;
    private boolean picture;
    private boolean gatefold;
    private boolean used;

    private int disks;

    public StoreItem(String artist, String title, String company, int year, String format,
                boolean heavyweight, boolean picture, boolean gatefold, boolean used, int disks) {
        this.artist = artist;
        this.title = title;
        this.company = company;
        this.year = year;
        this.format = format;
        this.heavyweight = heavyweight;
        this.picture = picture;
        this.gatefold = gatefold;
        this.used = used;
        this.disks = disks;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCompany() {
        return this.company;
    }

    public int getYear() {
        return this.year;
    }

    public String getFormat() {
        return this.format;
    }

    public boolean getHeavyweight() {
       return this.heavyweight;
    }

    public boolean getPicture() {
       return this.picture;
    }

    public boolean getGatefold() {
       return this.gatefold;
    }

    public boolean getUsed() {
       return this.used;
    }

    public int getDisks() {
       return this.disks;
    }
}
