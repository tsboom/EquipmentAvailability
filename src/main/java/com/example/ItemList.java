package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is an ArrayList of HashMaps containing keys and values
 * representing properties about each item available.
 *
 */
public class ItemList {
  private List<Item> items = new ArrayList<>();

  public ItemList() {
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public List<Item> getItems() {
    return items;
  }

  /**
   * This method will see if an item contains a particular value. It is used to
   * check if a sysnum exists, or if sublibrary exists for a particular item.
   *
   * @param pathParamValue
   *          This is the value provided in the URL
   * @return ItemList
   */
  public ItemList matchValue(String pathParamValue) {
    ItemList valueMatches = new ItemList();
    for (Item item : this.items) {
      if (item.getProperties().containsValue(pathParamValue)) {
        valueMatches.addItem(item);
      }
    }
    return valueMatches;
  }

  /**
   * This method checks to see if the value for a key is not empty. This is used
   * to see the items that are checked out.
   *
   * @param key
   * @return ItemList
   */
  public ItemList valueExists(String key) {
    ItemList valueExistsList = new ItemList();
    for (Item item : this.items) {
      if (item.get(key) != null && !item.get(key).isEmpty()) {
        valueExistsList.addItem(item);
      }
    }
    return valueExistsList;
  }

  /**
   * This method returns the size of the itemsList
   *
   * @return int
   */
  public int size() {
    // TODO Auto-generated method stub
    return this.items.size();
  }

}
