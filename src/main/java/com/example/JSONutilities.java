package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class is responsible for holding Gson utilities to process JSON
 */
public class JSONutilities {
  /**
   * This method creates JSON out of an ItemList
   * 
   * @param items
   * @return json representation of ItemList
   */
  public static String createJson(ItemList items) {
    Gson gson = new GsonBuilder().create();
    String json = gson.toJson(items);
    return json;
  }
}
