package com.pasimann.app;

import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.pasimann.app.model.StoreItem;
import com.pasimann.app.model.SummaryItem;
import com.pasimann.app.service.VinylStoreService;

@Controller
public class VinylStoreApiController {

    @Autowired
    VinylStoreService service;

    @RequestMapping(value={"/vinyl-store-search-artist"}, method=RequestMethod.GET)
    public @ResponseBody List<StoreItem> searchVinylStoreByArtist(
            @RequestParam(value="artist", required=true) String artist) {

        List<StoreItem> result = service.getArtistVinylItems(artist);
        return result;
    }

    @RequestMapping(value={"/vinyl-store-search-company"}, method=RequestMethod.GET)
    public @ResponseBody List<StoreItem> searchVinylStoreByCompany(
            @RequestParam(value="company", required=true) String company) {

        List<StoreItem> result = service.findVinylItemsByCompany(company);
        return result;
    }

    @RequestMapping(value={"/vinyl-store-search-title"}, method=RequestMethod.GET)
    public @ResponseBody List<StoreItem> searchVinylStoreByTitle(
            @RequestParam(value="title", required=true) String title) {

        List<StoreItem> result = service.findVinylItemsByTitle(title);
        return result;
    }

    @RequestMapping(value={"/vinyl-store-search-format"}, method=RequestMethod.GET)
    public @ResponseBody List<StoreItem> searchVinylStoreByFormat(
            @RequestParam(value="format", required=true) String format) {

        List<StoreItem> result = service.findVinylItemsByFormat(format);
        return result;
    }

    @RequestMapping(value={"/vinyl-store-count-by-artist"}, method=RequestMethod.GET)
    public @ResponseBody int countVinylItemsByArtist(
            @RequestParam(value="artist", required=true) String artist) {

        int result = service.countVinylItemsByArtist(artist);
        return result;
    }

    @RequestMapping(value={"/vinyl-store-count-total"}, method=RequestMethod.GET)
    public @ResponseBody int countVinylDiskTotal() {

        int result = service.countVinylDiskTotal();
        return result;
    }

    @RequestMapping(value={"/vinyl-store-summary-by-artist"}, method=RequestMethod.GET)
    public @ResponseBody List<SummaryItem> countVinylSummaryByArtist() {

        List<SummaryItem> result = service.countVinylSummaryByArtist();
        return result;
    }

    @RequestMapping(value={"/vinyl-store-summary-by-company"}, method=RequestMethod.GET)
    public @ResponseBody List<SummaryItem> countVinylSummaryByCompany() {

        List<SummaryItem> result = service.countVinylSummaryByCompany();
        return result;
    }

}
