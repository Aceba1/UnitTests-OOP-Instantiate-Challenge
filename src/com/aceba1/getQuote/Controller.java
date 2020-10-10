package com.aceba1.getQuote;

public class Controller {
  private final HotelMenu cli = new HotelMenu();
  private final Hotel hotel;

  public Controller(Hotel hotel) {
    this.hotel = hotel;
  }

  public void cycle() {
    cli.drawMenu(hotel);
  }
}
