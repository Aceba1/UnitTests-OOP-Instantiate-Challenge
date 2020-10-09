package com.aceba1.getQuote;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Controller {
  HotelMenu cli;
  Hotel hotel;
  Scanner in;

  public Controller(Hotel hotel) {
    in = new Scanner(System.in);
    this.hotel = hotel;
    this.cli = new HotelMenu();
  }

  public void cycle() {
    while (true) {
      System.out.println("Hotel CLI: " + hotel.getName() +
        "\nTotal rooms: " + hotel.getRooms() + "\nOccupied rooms");
      in.nextLine();
    }
  }
}
