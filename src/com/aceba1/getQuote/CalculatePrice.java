package com.aceba1.getQuote;

public class CalculatePrice {
  public static double getPrice(Room room) {
    double fee = room.getFee();
    double totalPrice = room.averagePrice;
    if (room instanceof StandardRoom) {
      var standard = (StandardRoom) room;

      if (room.isOccupied()) {
        int count = room.occupant.partySize;
        int recommended = standard.getRecommendedSpace();
        int maximum = standard.getAvailableSpace();
        if (count > recommended) {
          totalPrice += (count - recommended) * room.averagePrice * fee;
        }
        if (count > maximum) {
          totalPrice += (count - maximum) * room.averagePrice * 0.50;
        }
      }
    }
    return totalPrice;
  }
}
