package com.example;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.nodes.Document;

@Path("equipment")
public class EquipmentResource {
  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  public String getEquipment() {

    // get the HTML into jsoup
    Document doc = HTMLParser.parseDocument();

    // build the item list from parsed HTML
    List<Map> parsedItems = HTMLParser.createItemsList(doc);

    // instantiate itemList
    ItemList items = new ItemList(parsedItems);

    // convert items into Json
    String json = JSONutilities.createJson(items);

    return json;
  }

  // show items that are available in order of the least available
  @GET
  @Path("mostwanted")
  @Produces(MediaType.APPLICATION_JSON)
  public String getMostWanted() {

    // get the HTML into jsoup
    Document doc = HTMLParser.parseDocument();

    // build the item list from parsed HTML
    List<Map> items = HTMLParser.createItemsList(doc);

    return "return unavailable equipment";

  }

  // show items from a particular sublibrary
  @GET
  @Path("sublibrary/{sublib}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getItemsFromSublibrary(@PathParam("sublib") String sublib) {
    // get the HTML into jsoup
    Document doc = HTMLParser.parseDocument();

    // build the item list from parsed HTML
    List<Map> parsedItems = HTMLParser.createItemsList(doc);

    // instantiate itemList
    ItemList items = new ItemList(parsedItems);

    // find sublib
    items.setKeyMatches(sublib);
    // convert items into Json
    String json = JSONutilities.createJson(items);

    return json;

    // return "return items in specific sublibrary" + sublib;
  }

  // show a particular item by sys number
  @Path("{sysnum}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getItemsBySysnum(@PathParam("sysnum") String sysnum) {
    return "return items in specific sublibrary" + sysnum;
  }

  // show items that are due soon
  @Path("sublibrary/{sublib}/")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getItemsDue(@PathParam("sublib") String sublib) {
    return "return items in specific sublibrary" + sublib;
  }

}
