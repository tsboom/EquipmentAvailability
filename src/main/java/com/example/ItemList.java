package com.example;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
  // private List<Map<String, String>> items;
  private List<Item> items = new ArrayList<>();

  // constructor
  public ItemList() {
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public List<Item> getItems() {
    return items;
  }

  // filter by value provided in pathparam
  public ItemList matchValue(String pathParamValue) {
    ItemList valueMatches = new ItemList();
    for (Item item : this.items) {
      if (item.containsValue(pathParamValue)) {
        valueMatches.addItem(item);
      }
    }
    return valueMatches;
  }

  public int size() {
    // TODO Auto-generated method stub
    return this.items.size();
  }

  // public ItemList subList(int i, int size) {
  // // TODO Auto-generated method stub
  // return this.items.subList(1, this.size());
  // }
}
