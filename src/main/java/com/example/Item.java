package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an Item, which always has a HashMap of properties.
 */
public class Item {
  private Map<String, String> properties = new HashMap<>();

  // item constructor
  public Item() {
  }

  /**
   * This method adds a key and value to the properties.
   * @param key
   * @param value
   */
  public void addProperty(String key, String value) {
    properties.put(key, value);
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  /**
   * This method adds a key and value to the properties.
   * @param key
   */
  public String get(String key) {
    return properties.get(key);
  }

}
