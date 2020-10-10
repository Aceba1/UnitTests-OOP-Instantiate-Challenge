package com.aceba1.getQuote;

public class StandardRoom extends Room {

  @Override
  public double getFee() {
    return 0.05;
  }

  public static final int PARTY_ROOM_SIZE = 2;

  int rooms;
  int beds;

  public int getAvailableSpace() {
    return beds * PARTY_ROOM_SIZE + rooms * PARTY_ROOM_SIZE;
  }

  public int getRecommendedSpace() {
    return beds * PARTY_ROOM_SIZE;
  }

  public StandardRoom(int averagePrice, int number, int floor) {
    super(averagePrice, number, floor, "single");
    rooms = 1;
    beds = 1;
  }

  public StandardRoom(int averagePrice, int number, int floor, int rooms, int beds) {
    super(averagePrice, number, floor, "single");
    this.rooms = rooms;
    this.beds = beds;
  }

  protected StandardRoom(int averagePrice, int number, int floor, int rooms, int beds, String type) {
    super(averagePrice, number, floor, type);
    this.rooms = rooms;
    this.beds = beds;
  }

  @Override
  public boolean reserve(Client client) {
    int space = getAvailableSpace();
    if (client.partySize > space) { // client.partySize > beds * PARTY_ROOM_SIZE
      System.out.println("Room is unavailable: Not enough space (" + client.partySize + " > " + space + ")");
      return false;
    }
    return super.reserve(client);
  }

  protected boolean reserveIgnoreSpace(Client client) {
    return super.reserve(client);
  }

  @Override
  public String toString() {
    return "StandardRoom " + number + " (price=$" + averagePrice + ", rooms=" + rooms + ", beds=" + beds + "): " +
      (isOccupied ? "occupied (" + occupant.name + ", " + occupant.phoneNumber +")" :
        (needsCleaning ? "needs cleaning" : "ready"));
  }

  public int getRooms() {
    return rooms;
  }

  public int getBeds() {
    return beds;
  }
}
