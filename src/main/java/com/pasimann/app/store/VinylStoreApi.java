package com.pasimann.app.store;

import java.util.List;

import com.pasimann.app.model.StoreItem;

public interface VinylStoreApi {
   public List<StoreItem> loadStoreItems();
}
