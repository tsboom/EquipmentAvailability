package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONutilities {
  public static String createJson(ItemList items) {
    Gson gson = new GsonBuilder().create();
    String json = gson.toJson(items);
    return json;
  }
}
