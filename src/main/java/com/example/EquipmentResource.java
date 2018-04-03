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
  /**
   * This service returns a list of all of the equipment from the Laptops
   * program
   *
   * @return json representation of all equipment items and their properties.
   */
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

    return json;
  }

  /**
   * This service returns a list of equipment from a particular sublibrary
   * program
   *
   * @param sublib
   *          The string code for sublib is provided in the path.
   * @return json representation of equipment from the sublib.
   */
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

  /**
   * This service returns an item with a particular sysnumber. program
   *
   * @param sysnum
   *          The string of the sysnumber is provided in the path.
   * @return json representation of the item matching the sysnumber.
   */
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

  /**
   * This service returns an list of items that are checked out. The list is
   * sorted with the soonest due at the top.
   *
   * @return json representation of items checked out.
   */
  @Path("checkedout")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getItemsDue() {
    // get the HTML into jsoup
    Document doc = HTMLParser.parseDocument();

    // build the item list from parsed HTML
    ItemList itemList = HTMLParser.createItemsList(doc);

    // find matching items with "mindue"
    ItemList matchedItems = itemList.valueExists("mindue");

    // sort by soonest due
    Collections.sort(matchedItems.getItems(), new ItemComparator("mindue",
        "DESC"));

    // convert items into Json
    String json = JSONutilities.createJson(matchedItems);

    return json;
  }

}
