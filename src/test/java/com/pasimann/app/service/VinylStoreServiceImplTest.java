package com.pasimann.app.service;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.pasimann.app.service.VinylStoreService;
import com.pasimann.app.service.VinylStoreServiceImpl;
import com.pasimann.app.model.StoreItem;


public class VinylStoreServiceImplTest extends TestCase {

    public VinylStoreServiceImplTest(String name) {
        super(name);
    }

    public static Test suite() {
        return new TestSuite( VinylStoreServiceImplTest.class );
    }

    public void testSearchByArtist() {

        VinylStoreService service = new VinylStoreServiceImpl();

    }
}
