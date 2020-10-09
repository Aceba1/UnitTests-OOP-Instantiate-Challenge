package com.aceba1.getQuote;

public class SuiteRoom extends StandardRoom {

  boolean kitchenette;
  boolean needsRestock;

  public SuiteRoom(int averagePrice, int number, int floor) {
    super(averagePrice, number, floor, 1, 1, "suite");
    this.kitchenette = true;
  }

  public SuiteRoom(int averagePrice, int number, int floor, int rooms, int beds, boolean kitchenette) {
    super(averagePrice, number, floor, rooms, beds, "suite");
    this.kitchenette = kitchenette;
  }

  public void restock() {
    needsRestock = false;
  }

  @Override
  public String toString() {
    return "SuiteRoom{" +
      "kitchenette=" + kitchenette +
      ", needsRestock=" + needsRestock +
      "} " + super.toString();
  }

  @Override
  public boolean reserve(Client client) {
    if (needsRestock) {
      System.out.println("Unavailable: Needs restock");
      return false;
    }
    return super.reserve(client);
  }

  @Override
  public void checkout() {
    needsRestock = true;
    super.checkout();
  }



  public boolean isKitchenette() {
    return kitchenette;
  }

  public boolean isNeedsRestock() {
    return needsRestock;
  }
}
