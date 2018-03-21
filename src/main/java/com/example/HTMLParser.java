package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  public static List<Map<String, String>> createItemsList(Document document) {
    // initialize ArrayList of items
    ArrayList<Map<String, String>> items = new ArrayList<>();
    // select all table row sections
    Elements rows = document.select("tr");
    for (Element row : rows) {
      Elements tds = row.getElementsByTag("td");
      Map<String, String> item = new HashMap<String, String>();
      for (Element td : tds) {
        String className = td.attr("class");
        String value = td.text();
        item.put(className, value);
      }
      items.add(item);
    }

    // ignore first object in ArrayList b/c it's empty
    List<Map<String, String>> itemsMinusFirst = items.subList(1, items.size());

    // try {
    // Collections.sort(itemsMinusFirst, (o1, o2) -> new Integer(((String)
    // o1.get("total")))
    // .compareTo(new Integer(((String) o2.get("total")))));
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    return itemsMinusFirst;
  }

}
