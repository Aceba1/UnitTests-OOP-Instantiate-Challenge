package com.aceba1.getQuote;

public class Client {

  private final String name;
  private final String phoneNumber;

  private final int partySize;

  private int currentBill;
  private int prepaid;

  Room room;

  public Client(String name, String phoneNumber, int partySize) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.partySize = partySize;
  }

  @Override
  public String toString() {
    return "Client{" +
      "name='" + name + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      ", partySize=" + partySize +
      ", currentBill=" + currentBill +
      ", prepaid=" + prepaid +
      ", outstanding=" + getOutstanding() +
      ", roomNumber=" + getRoomNumber() +
      ", roomType='" + getRoomType() + '\'' +
      '}';
  }

  public void makePayment(int amount) {
    prepaid += amount;
  }

  public void chargeRoom(int amount) {
    currentBill += amount;
  }

  public int getOutstanding() {
    return currentBill - prepaid;
  }

  public int getRoomNumber() {
    return room.getNumber();
  }

  public String getRoomType() {
    return room.getType();
  }


  public String getName() { return name; }

  public int getPartySize() { return partySize; }

  public String getPhoneNumber() { return phoneNumber; }

  public int getCurrentBill() { return currentBill; }

  public int getPrepaid() { return prepaid; }

  public Room getRoom() { return room; }
}
