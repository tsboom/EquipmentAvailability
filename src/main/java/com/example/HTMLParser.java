package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {
  Document doc;
  ArrayList<Map> items;

  public Parsed(Document doc, ArrayList<Map> items) {
    doc = null;
    items = null;
  }

  // load the HTML from the Laptops application URL
  public Document getDocument() {
    try {
      doc = Jsoup.connect("http://catalog.umd.edu/cgi-bin/laptops").get();
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }
    return doc;
  }

  public void setDocument(Document doc) {
    this.doc = doc;
  }

  public ArrayList<Map> getItems(ArrayList<Map> items) {
    return items;
  }

  // Build list of items from parsing HTML table
  public void setItems(ArrayList<Map> items) {
    // select all table row sections
    Elements rows = doc.select("tr");
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
    this.items = items;
  }

}
