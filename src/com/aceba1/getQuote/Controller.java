package com.aceba1.getQuote;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Controller {
  HotelMenu cli = new HotelMenu();
  Hotel hotel;

  public Controller(Hotel hotel) {
    this.hotel = hotel;
  }

  public void cycle() {
    cli.drawMenu(hotel);
  }
}
