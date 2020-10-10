package com.aceba1.getQuote;

public class RentRoomMenu extends CommandMenu<Hotel> {

  Client tempClient = null;

  static Client createClient() {
    return new Client(
      getLine("Client name: "),
      getLine("Phone number: "),
      getNum("Party size: ", 1, 100)
    );
  }

  @Override
  void drawMenu(Hotel hotel) {
//    switch(getNum(
//      "[0]New or [1]Existing client? : ", 0, 1)) {
//      case 0:
    if (tempClient != null) {
      System.out.println("\nClient still in session: " + tempClient.name + ", Party: " + tempClient.partySize);
      if (getNum("[0]New client, or [1]Existing session? : ", 0, 1) == 0)
        tempClient = createClient();
    } else {
      tempClient = createClient();
    }

    System.out.println("\nYou can now examine rooms and come back if necessary. Leave with 0");

    while (true) {
      int roomNumber = getNum("\nRoom number: ", 0, 999);
      if (roomNumber == 0) return;

      Room room = hotel.getRoom(roomNumber);
      if (room == null) {
        System.out.println("Room does not exist!");
      } else {
        System.out.println(room);
        if (room.reserve(tempClient)) {
          hotel.clients.add(tempClient);
          tempClient = null;
          System.out.println("Room " + roomNumber + " has been reserved!");

          if (getNum("Add pre-payment? (0-" + + "): ", 0, 1))
          return;
        }
      }
    }
  }
}
