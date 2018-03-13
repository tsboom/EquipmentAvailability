package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemList {
  public List<Map> items;

  // constructor
  public ItemList(List<Map> parsedItems) {
    items = parsedItems;
  }

  // filter by key provided in pathparam
  public void setKeyMatches(String key) {
    for (Map<String, String> item : items) {
      if ()

    }
  }

  // filter by value provided in pathparam

}
