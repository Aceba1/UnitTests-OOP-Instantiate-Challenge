package com.aceba1.getQuote;

public abstract class Room {

  public double getFee() {
    return 0.00;
  }

  private final int averagePrice;
  private final int number;
  private final int floor;
  private final String type;

  private boolean isOccupied;
  private boolean needsCleaning;
  private Client occupant;

  public Room(int averagePrice, int number, String type) {
    this.averagePrice = averagePrice;
    this.number = number;
    this.floor = number / 100;
    this.type = type;
  }

  public boolean reserve(Client client) {
    if (isOccupied || needsCleaning) {
      System.out.println("Room is unavailable: " + (isOccupied ? "Is occupied" : "Needs cleaning"));
      return false;
    }
    isOccupied = true;
    occupant = client;
    client.room = this;
    client.chargeRoom((int)CalculatePrice.getPrice(this)); // For sanity
    return true;
  }

  public void checkout() {
    System.out.println("Outstanding price: $" + occupant.getOutstanding());
    occupant = null;
    isOccupied = false;
    needsCleaning = true;
  }

  public void clean() {
    needsCleaning = false;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Room && ((Room) obj).number == number;
  }

  @Override
  public String toString() {
    return "Room " + number +
      (isOccupied ? ": occupied (" + occupant.getName() + ", " + occupant.getPhoneNumber() +")" :
        (needsCleaning ? ": needs cleaning" : ": ready"));
  }

  public int getAveragePrice() {
    return averagePrice;
  }

  public int getNumber() {
    return number;
  }

  public int getFloor() {
    return floor;
  }

  public String getType() {
    return type;
  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public boolean getNeedsCleaning() {
    return needsCleaning;
  }

  public Client getOccupant() {
    return occupant;
  }
}
