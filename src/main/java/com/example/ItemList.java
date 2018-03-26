package com.example;

import java.util.ArrayList;

public class ItemList {
  // private List<Map<String, String>> items;
  private ArrayList<Item> items;

  // constructor
  public ItemList() {
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  // filter by value provided in pathparam
  public ItemList matchValue(String pathParamValue) {
    ItemList valueMatches = new ItemList();
    for (Item item : items) {
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

  public ItemList subList(int i, int size) {
    // TODO Auto-generated method stub
    return this.items.subList(1, this.size());
  }
}
