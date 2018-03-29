package com.example;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This class is responsible for implementing HTML parsing methods.
 */
public class HTMLParser {
  /**
   * This method parses the HTML from the Laptops application URL
   * @return doc
   */
  public static Document parseDocument() {
    Document doc = null;
    try {
      doc = Jsoup.connect("http://catalog.umd.edu/cgi-bin/laptops").get();
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }

    return doc;
  }
  /**
   * This method builds a list of items by parsing the HTML table.
   * @return itemList
   */
  public static ItemList createItemsList(Document document) {
    // initialize ArrayList of items
    ItemList itemList = new ItemList();
    // select all table row sections
    Elements rows = document.select("tr");
    // iterate over all rows except the first
    for (int i = 1; i < rows.size(); i++) {
      Element row = rows.get(i);
      Elements tds = row.getElementsByTag("td");
      Item item = new Item();
      for (Element td : tds) {
        String className = td.attr("class");
        String value = td.text();
        item.addProperty(className, value);
      }
      itemList.addItem(item);
    }

    return itemList;
  }

}
