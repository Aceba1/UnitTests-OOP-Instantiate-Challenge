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
    return "SuiteRoom " + number + " (rooms=" + rooms + ", beds=" + beds + ", kitchenette="+ kitchenette + "): " +
      (isOccupied ? "occupied (" + occupant.name + ", " + occupant.phoneNumber +")" :
        (needsCleaning ? "needs cleaning" :
          (needsRestock ? "needs restock" : "ready")));
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



  public boolean hasKitchenette() {
    return kitchenette;
  }

  public boolean getNeedsRestock() {
    return needsRestock;
  }
}
