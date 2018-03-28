package com.example;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
  private String direction = "ASC";
  private String sortKey = null;

  public ItemComparator(String sortKey, String direction) {
    this.sortKey = sortKey;
    this.direction = direction;
  }

  public ItemComparator sortBy(String sortKey, String direction) {
    this.sortKey = sortKey;
    this.direction = direction;
    return this;
  }

  @Override
  public int compare(Item i1, Item i2) {
    // sorting numbers
    if (i1.get(sortKey).chars().allMatch(Character::isDigit)) {
      int i1Value = Integer.parseInt(i1.get(sortKey));
      int i2Value = Integer.parseInt(i2.get(sortKey));
      if (direction == "ASC") {
        // ascending order
        return i1Value - i2Value;
      } else {
        // descending order
        return i2Value - i1Value;
      }
    } else {
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

}
