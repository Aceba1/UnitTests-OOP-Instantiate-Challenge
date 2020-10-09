package com.aceba1.getQuote;

public abstract class Room {

  int averagePrice;
  int number;
  int floor;
  String type;

  boolean isOccupied;
  boolean needsCleaning;
  Client occupant;

  public Room(int averagePrice, int number, int floor, String type) {
    this.averagePrice = averagePrice;
    this.number = number;
    this.floor = floor;
    this.type = type;
  }

  public boolean reserve(Client client) {
    if (isOccupied || needsCleaning) {
      System.out.println("Room is unavailable: " + (isOccupied ? "Is occupied" : "Needs cleaning"));
      return false;
    }
    isOccupied = true;
    occupant = client;
    return true;
  }

  public void checkout() {
    occupant = null;
    isOccupied = false;
    needsCleaning = true;
    System.out.println("price: $" + averagePrice);
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
    return "Room{" +
      "averagePrice=" + averagePrice +
      ", number=" + number +
      ", floor=" + floor +
      ", type='" + type + '\'' +
      ", isOccupied=" + isOccupied +
      ", needsCleaning=" + needsCleaning +
      ", occupant=" + occupant +
      '}';
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

  public boolean isNeedsCleaning() {
    return needsCleaning;
  }

  public Client getOccupant() {
    return occupant;
  }
}
