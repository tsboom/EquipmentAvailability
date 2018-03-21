package com.example;

import java.util.Comparator;
import java.util.Map;

public class Item implements Comparable<Item> {
  private Map<String, String> properties;

  // item constructor
  public Item(Map<String, String> properties) {
    this.properties = properties;
  }

  // get the value of the property based on key
  public String get(String key) {
    return properties.get(key);
  }

  public static Comparator<Item> ItemsKeyComparator = new Comparator<Item>() {
    @Override
    // i1Value and i2Value are the value of the property provided in
    // properties.get(key)
    public int compare(Item i1Value, Item i2Value) {
      return i1Value.compareTo(i2Value);
    }
  };

  @Override
  public int compareTo(Item o) {
    // TODO Auto-generated method stub
    return 0;
  }

}
