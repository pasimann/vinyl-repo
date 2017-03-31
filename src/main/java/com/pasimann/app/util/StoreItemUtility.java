package com.pasimann.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreItemUtility {
  private static Logger log = LoggerFactory.getLogger(StoreItemUtility.class);

  public static boolean parseBoolean(String value) {
     if (value != null) {
       if (value.equals("Y")) {
          return true;
       } else if (value.equals("N")) {
          return false;
       } else {
          log.warn("Wrong boolean value: " +value);
       }
     } else {
        log.warn("Wrong (null) boolean value.");
     }
     return false;
  }

  public static int checkFormat(String[] formats, String value) {
     for (String s : formats) {
       if (s.equals(value)) {
         if (value.equals("LP")) {
           return 1;
         }
         if (value.equals("2LP")) {
           return 2;
         }
         if (value.equals("3LP")) {
           return 3;
         }
         if (value.equals("4LP")) {
           return 4;
         }
         if (value.equals("5LP")) {
           return 5;
         }
         if (value.equals("6LP")) {
           return 6;
         }
         if (value.equals("7LP")) {
           return 7;
         }
         if (value.equals("8LP")) {
           return 8;
         }
         if (value.equals("9LP")) {
           return 9;
         }
         if (value.equals("10LP")) {
           return 10;
         }
         if (value.equals("7\"")) {
           return 1;
         }
         if (value.equals("10\"")) {
           return 1;
         }
         if (value.equals("12\"")) {
           return 1;
         }
         if (value.equals("2x10\"")) {
           return 2;
         }
         if (value.equals("2x12\"")) {
           return 2;
         }
       }
     }
     log.warn("Invalid record format: " +value);
     return 0;
  }

}
