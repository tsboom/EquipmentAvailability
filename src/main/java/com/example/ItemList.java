package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemList {
  private List<Map<String, String>> items;

  // constructor
  public ItemList(List<Map<String, String>> parsedItems) {
    this.items = parsedItems;
  }

  public List<Map<String, String>> getItems() {
    return items;
  }

  // filter by value provided in pathparam
  public ItemList matchValue(String pathParamValue) {
    List<Map<String, String>> valueMatches = new ArrayList<>();
    for (Map<String, String> item : items) {
      if (item.containsValue(pathParamValue)) {
        valueMatches.add(item);
      }
    }
    return new ItemList(valueMatches);
  }
}

// sort by key provided in pathparam
