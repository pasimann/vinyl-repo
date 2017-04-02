package com.pasimann.app.model;

public class SummaryItem {

    private String name;
    private int count;

    public SummaryItem(String name, int count) {
       this.name = name;
       this.count = count;
    }

    public String getName() {
       return name;
    }

    public int getCount() {
       return count;
    }
}
