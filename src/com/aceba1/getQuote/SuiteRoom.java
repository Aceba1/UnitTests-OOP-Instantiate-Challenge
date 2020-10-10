package com.aceba1.getQuote;

public class SuiteRoom extends StandardRoom {

  @Override
  public double getFee() {
    return 0.08;
  }

  private final boolean kitchenette;

  private boolean needsRestock;

  public SuiteRoom(int averagePrice, int number) {
    super(averagePrice, number, 1, 1, "suite");
    this.kitchenette = true;
  }

  public SuiteRoom(int averagePrice, int number, int rooms, int beds, boolean kitchenette) {
    super(averagePrice, number, rooms, beds, "suite");
    this.kitchenette = kitchenette;
  }

  public void restock() {
    needsRestock = false;
  }

  @Override
  public String toString() {
    return "SuiteRoom " + getNumber() + " (price=$" + getAveragePrice() +
      ", rooms=" + getRooms() + ", beds=" + getBeds() + ", kitchenette="+ kitchenette + "): " +
      (isOccupied() ? "occupied (" + getOccupant().getName() + ", " + getOccupant().getPhoneNumber() +")" :
        (getNeedsCleaning() ? "needs cleaning" :
          (needsRestock ? "needs restock" : "ready")));
  }

  @Override
  public boolean reserve(Client client) {
    if (needsRestock) {
      System.out.println("Unavailable: Needs restock");
      return false;
    }
    return reserveIgnoreSpace(client);
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
