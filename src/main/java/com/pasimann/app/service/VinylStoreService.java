package com.pasimann.app.service;

import java.util.List;

import com.pasimann.app.model.StoreItem;

public interface VinylStoreService {

    public List<StoreItem> getAllVinylItems();
    public List<StoreItem> getArtistVinylItems(String artist);

    public List<StoreItem> findVinylItemsByCompany(String company);
    public List<StoreItem> findVinylItemsByTitle(String title);

    public List<StoreItem> findVinylItemsByYear(int year);
    public List<StoreItem> findVinylItemsByFormat(String format);

    public int countVinylItemsByArtist(String artist);
    public int countVinylDiskTotal();
}
