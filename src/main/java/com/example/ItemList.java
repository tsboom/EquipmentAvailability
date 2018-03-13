package com.example;

import java.util.List;
import java.util.Map;

public class ItemList {
  public List<Map> items;

  // constructor
  public ItemList(List<Map> parsedItems) {
    items = parsedItems;
  }

  // filter by key provided in pathparam
  public void setKeyMatches(String pathParamKey) {
    List<Map> keyMatches = null;
    for (Map<String, String> item : items) {
      String value = item.get(pathParamKey);
      if (value != null) {
        keyMatches.add(item);
      }
    }
    System.out.println(keyMatches);
    this.items = keyMatches;
  }

  // filter by value provided in pathparam
  public void setValueMatches(String pathParamValue) {
    List<Map> valueMatches = null;
    for (Map<String, String> item : items) {
      if (item.containsValue(pathParamValue)) {
        valueMatches.add(item);
      }
      System.out.println(valueMatches);
      this.items = valueMatches;
    }
  }

}
