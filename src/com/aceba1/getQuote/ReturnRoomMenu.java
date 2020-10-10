package com.aceba1.getQuote;

public class ReturnRoomMenu extends CommandMenu<Hotel> {

  @Override
  void drawMenu(Hotel hotel) {
    System.out.print("\nRoom-Checkout");
    while (true) {
      int roomNumber = getNum("\nRoom number: ", 0, 999);
      if (roomNumber == 0) return;

      Room room = hotel.getRoom(roomNumber);
      if (room == null) {
        System.out.println("Room does not exist!");
      } else if (!room.isOccupied()) {
        System.out.println("Room is not occupied!");
      } else {
        String line = getLine("Enter client's name to confirm: ");
        if (room.occupant.name.equals(line)) {
          room.checkout();
          System.out.println(room +
            "\nCheckout complete!\n\nExamine the room number to handle maintenance");
          return;
        } else {
          System.out.println("Name does not match!");
        }
      }
    }
  }
}
