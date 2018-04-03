package com.example;

import java.util.Comparator;

/**
 * This class implements a Comparator that takes a key to sort by, and a sort
 * direction.
 */
public class ItemComparator implements Comparator<Item> {
  private String direction = "ASC";
  private String sortKey = null;

  public ItemComparator(String sortKey, String direction) {
    this.sortKey = sortKey;
    this.direction = direction;
  }

  /**
   * This method returns a -1, 0, or 1 to indicate how to sort two items
   *
   * @param i1
   * @param i2
   * @return -1, 0, 1 integer that is used to help sort two objects
   */
  @Override
  public int compare(Item i1, Item i2) {
    // sort for String values
    if (direction == "ASC") {
      // ascending order
      return i1.get(sortKey).compareTo(i2.get(sortKey));
    } else {
      // descending order
      return i2.get(sortKey).compareTo(i1.get(sortKey));
    }

  }
}
