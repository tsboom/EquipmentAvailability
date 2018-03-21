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
    List<Map<String, String>> parsedItems = HTMLParser.createItemsList(doc);

    // instantiate itemList
    ItemList items = new ItemList(parsedItems);

    // convert items into Json
    String json = JSONutilities.createJson(items);

    return json;
  }

  // show items from a particular sublibrary
  @GET
  @Path("sublib/{sublib}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getItemsFromSublibrary(@PathParam("sublib") String sublib) {
    // get the HTML into jsoup
    Document doc = HTMLParser.parseDocument();

    // build the item list from parsed HTML
    List<Map<String, String>> parsedItems = HTMLParser.createItemsList(doc);

    // instantiate itemList
    ItemList items = new ItemList(parsedItems);

    // find sublib
    ItemList filteredItems = items.matchValue(sublib);

    // convert items into Json
    String json = JSONutilities.createJson(filteredItems);

    return json;

  }

  // show a particular item by sys number
  @Path("sysnum/{sysnum}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getItemsBySysnum(@PathParam("sysnum") String sysnum) {
    // get the HTML into jsoup
    Document doc = HTMLParser.parseDocument();

    // build the item list from parsed HTML
    List<Map<String, String>> parsedItems = HTMLParser.createItemsList(doc);

    // instantiate itemList
    ItemList items = new ItemList(parsedItems);

    // find sysnum
    ItemList filteredItems = items.matchValue(sysnum);

    // convert items into Json
    String json = JSONutilities.createJson(filteredItems);

    return json;

  }

  // show items that are checked out. sort by soonest due
  @Path("checkedout")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getItemsDue(@PathParam("sublib") String sublib) {
    return "return items in specific sublibrary" + sublib;
  }

}
