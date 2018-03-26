package com.example;

import java.util.Comparator;
import java.util.Map;

public class Item implements Comparable<Item> {
  private Map<String, String> properties;

  // item constructor
  public Item() {
  }

  public void addProperty(String key, String value) {
    this.properties.put(key, value);
  }

  public Map<String, String> getProperties() {
    return this.properties;
  }

  // get the value of the property based on key
  public String get(String key) {
    return properties.get(key);
  }

  public boolean containsValue(String pathParamValue) {
    // TODO Auto-generated method stub

    return false;
  }

  public int compareTo(Item compareItem, String key) {
    int compareValue = compareItem.get(key);
  }

  public static Comparator<Item> ItemsKeyComparator = new Comparator<Item>() {
    @Override
     // i1Value and i2Value are the value of the property provided in
   // properties.get(key)
    public int compare(Item i1.mindue, Item i2.mindue) {
      return  i1.mindue.compareTo(i2.mindue);
    }
  };

}
