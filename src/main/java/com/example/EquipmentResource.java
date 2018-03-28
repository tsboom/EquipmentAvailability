package com.example;

import java.util.Collections;

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
    ItemList itemList = HTMLParser.createItemsList(doc);

    // convert items into Json
    String json = JSONutilities.createJson(itemList);
    System.out.print("here");

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
    ItemList itemList = HTMLParser.createItemsList(doc);

    // find sublib
    ItemList filteredItems = itemList.matchValue(sublib);

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
    ItemList itemList = HTMLParser.createItemsList(doc);

    // find sysnum
    ItemList filteredItems = itemList.matchValue(sysnum);

    // convert items into Json
    String json = JSONutilities.createJson(filteredItems);

    return json;

  }

  // show items that are checked out. sort by soonest due
  @Path("checkedout")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getItemsDue() {
    // get the HTML into jsoup
    Document doc = HTMLParser.parseDocument();

    // build the item list from parsed HTML
    ItemList itemList = HTMLParser.createItemsList(doc);

    // find matching items with "mindue"
    ItemList matchedItems = new ItemList();
    for (Item item : matchedItems.getItems()) {
      if (item.get("mindue") != null) {
        matchedItems.addItem(item);
      }
    }

    // sort by soonest due
    Collections.sort(matchedItems.getItems(), new ItemComparator("mindue", "DESC"));

    // convert items into Json
    String json = JSONutilities.createJson(matchedItems);

    return json;
  }

}
