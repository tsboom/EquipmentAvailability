package com.example;

import java.util.HashMap;
import java.util.Map;

public class Item {
  private Map<String, String> properties = new HashMap<>();
  // private String sortKey;

  // item constructor
  public Item() {
  }

  public void addProperty(String key, String value) {
    properties.put(key, value);
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  // get the value of the property based on key
  public String get(String key) {
    return properties.get(key);
  }

  public boolean containsValue(String pathParamValue) {
    // TODO Auto-generated method stub

    return false;
  }

}
