package com.aceba1.getQuote;

public class Client {

  String name;
  String phoneNumber;
  int partySize;

  int currentBill;
  int prepaid;

  int roomNumber;
  String roomType;

  @Override
  public String toString() {
    return "Client{" +
      "name='" + name + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      ", partySize=" + partySize +
      ", currentBill=" + currentBill +
      ", prepaid=" + prepaid +
      ", roomNumber=" + roomNumber +
      ", roomType='" + roomType + '\'' +
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
}
