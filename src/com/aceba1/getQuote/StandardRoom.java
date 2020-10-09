package com.aceba1.getQuote;

public class StandardRoom extends Room {

  public static final int PARTY_ROOM_SIZE = 2;

  int rooms;
  int beds;

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
    if (client.partySize > beds * PARTY_ROOM_SIZE) {
      System.out.println("Room is unavailable: Not enough rooms");
      return false;
    }
    return super.reserve(client);
  }

  @Override
  public String toString() {
    return "StandardRoom{" +
      "rooms=" + rooms +
      ", beds=" + beds +
      "} " + super.toString();
  }

  public int getRooms() {
    return rooms;
  }

  public int getBeds() {
    return beds;
  }
}
