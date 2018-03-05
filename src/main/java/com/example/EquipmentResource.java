package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("equipment")
public class EquipmentResource {

  @Path("all")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getEquipment() {
    Document doc = null;
    try {
      // wrap in try /catch b/c of IO exception
      // load the HTML from the Laptops application URL
      doc = Jsoup.connect("http://catalog.umd.edu/cgi-bin/laptops").get();
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }

    ArrayList<Map> items = new ArrayList<>();

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

    // convert HashMap into Json
    Gson gson = new GsonBuilder().create();
    String json = gson.toJson(items);

    return json;
  }

  @Path("available")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getAvailable() {
    return "return available equipment";

  }
}
