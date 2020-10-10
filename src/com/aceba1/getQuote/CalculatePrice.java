package com.aceba1.getQuote;

public class CalculatePrice {
  public static double getPrice(Room room) {
    double fee = room.getFee();
    double totalPrice = room.getAveragePrice();
    if (room instanceof StandardRoom) {
      var standard = (StandardRoom) room;

      if (room.isOccupied()) {
        int count = room.getOccupant().getPartySize();
        int recommended = standard.getRecommendedSpace();
        int maximum = standard.getAvailableSpace();
        if (count > recommended) {
          totalPrice += (count - recommended) * room.getAveragePrice() * fee;
        }
        if (count > maximum) {
          totalPrice += (count - maximum) * room.getAveragePrice() * 0.50;
        }
      }
    }
    return totalPrice;
  }
}
