package com.example;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {

  // load the HTML from the Laptops application URL
  public static Document parseDocument() {
    Document doc = null;
    try {
      doc = Jsoup.connect("http://catalog.umd.edu/cgi-bin/laptops").get();
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }

    return doc;
  }

  // Build list of items from parsing HTML table
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
        // why can't I see these vars in the debugger
        String className = td.attr("class");
        String value = td.text();
        item.addProperty(className, value);
      }
      itemList.addItem(item);
    }

    // // ignore first object in ArrayList b/c it's empty
    // ItemList itemsMinusFirst = new ItemList();
    // itemsMinusFirst = (ItemList) itemList.getItems().subList(1,
    // itemList.size());
    // return itemsMinusFirst;
    return itemList;
  }

}
