package com.pasimann.app.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.lang.Integer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pasimann.app.model.StoreItem;
import com.pasimann.app.util.StoreItemUtility;

@Service
public class VinylStoreImpl implements VinylStoreApi {
   private static Logger log = LoggerFactory.getLogger(VinylStoreImpl.class);

   private static final String PROPERTIES_FILENAME = "VINYLREPO";

   private static ResourceBundle propertiesBundle;

   static {
       propertiesBundle = ResourceBundle.getBundle(PROPERTIES_FILENAME);
   }

   private StoreItem createStoreItem(String[] words, String[] formats) {
      StoreItem item =
        new StoreItem(
           words[0], words[1], words[2],
           Integer.parseInt(words[3]),
           words[4],
           StoreItemUtility.parseBoolean(words[5]),
           StoreItemUtility.parseBoolean(words[6]),
           StoreItemUtility.parseBoolean(words[7]),
           StoreItemUtility.parseBoolean(words[8]),
           StoreItemUtility.checkFormat(formats, words[4]));
      return item;
   }

   @Override
   public List<StoreItem> loadStoreItems() {
     List<StoreItem> result = new ArrayList<StoreItem>();

     BufferedReader buffer = null;

     try {
        String filename    = propertiesBundle.getString("vinylrepo.filename");
        String[] structure = propertiesBundle.getString("vinylrepo.structure").split(",");
        String[] formats = propertiesBundle.getString("vinylrepo.formats").split(",");

        log.info("Reading store file... " +filename);

        String line = null;
        String[] words;
        int nro = 0;

        buffer = new BufferedReader(new FileReader(filename));

        do {
          nro++;
          line = buffer.readLine();

          if (line != null) {
            words = line.split("\t");

            if (words.length == structure.length) {
              StoreItem item = createStoreItem(words, formats);
              result.add(item);
            } else {
              log.error("Invalid file structure in line: " +nro);
              result.clear();
              break;
            }

          } else {
            log.info("End of file. Read lines: " +nro);
          }

        } while (line != null);

        buffer.close();

     } catch (Exception e) {
       log.error("Errors while reading file.");
       e.printStackTrace();
     }

     return result;
   }
}
