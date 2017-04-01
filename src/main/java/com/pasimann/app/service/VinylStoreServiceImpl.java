package com.pasimann.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

import com.pasimann.app.model.StoreItem;
import com.pasimann.app.model.SummaryItem;
import com.pasimann.app.service.VinylStoreService;
import com.pasimann.app.store.VinylStoreApi;

@Service
public class VinylStoreServiceImpl implements VinylStoreService {

    @Autowired
    private VinylStoreApi store;

    private List<StoreItem> items;

    public VinylStoreServiceImpl() { }

    @PostConstruct
    public void init() {
      items = store.loadStoreItems();
    }

    @Override
    public List<StoreItem> getAllVinylItems() {
      return items;
    }

    @Override
    public List<StoreItem> getArtistVinylItems(String artist) {
      List<StoreItem> result =
          items.stream()
	          .filter(item -> item.getArtist().equals(artist))
	          .collect(Collectors.toList());
      return result;
    }

    @Override
    public List<StoreItem> findVinylItemsByCompany(String company) {
      List<StoreItem> result =
          items.stream()
	          .filter(item -> item.getCompany().equals(company))
	          .collect(Collectors.toList());
      return result;
    }

    @Override
    public List<StoreItem> findVinylItemsByTitle(String title) {
      List<StoreItem> result =
          items.stream()
	          .filter(item -> item.getTitle().equals(title))
	          .collect(Collectors.toList());
      return result;
    }

    @Override
    public List<StoreItem> findVinylItemsByYear(int year) {
      List<StoreItem> result =
          items.stream()
	          .filter(item -> item.getYear() == year)
	          .collect(Collectors.toList());
      return result;
    }

    @Override
    public List<StoreItem> findVinylItemsByFormat(String format) {
      List<StoreItem> result =
          items.stream()
	          .filter(item -> item.getFormat().equals(format))
	          .collect(Collectors.toList());
      return result;
    }

    @Override
    public int countVinylItemsByArtist(String artist) {
      List<StoreItem> result = getArtistVinylItems(artist);
      return result.size();
    }

    @Override
    public int countVinylDiskTotal() {
      int count = 0;
      for (StoreItem item : items) {
          count = count + item.getDisks();
      }
      return count;
    }

    @Override
    public List<SummaryItem> countVinylSummaryByArtist() {
      List<SummaryItem> result = new ArrayList<>();

      List<String> artists = this.getDistinctArtists();

      for (String artist : artists) {
         List<StoreItem> items = getArtistVinylItems(artist);
         SummaryItem s = new SummaryItem(artist, items.size());
         result.add(s);
      }
      return result;
    }

    private List<String> getDistinctArtists() {
      List<String> artists = new ArrayList<>();
      artists.add(items.get(0).getArtist());

      for (StoreItem item : items) {
        boolean found = false;

        for (String artist : artists) {
          if (artist.equals(item.getArtist())) {
            found = true;
            break;
          }
        }
        if (!found) {
           artists.add(item.getArtist());
        }
      }
      return artists;
    }
}
