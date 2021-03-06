package com.aceba1.getQuote;

public class HotelMenu extends CommandMenu<Hotel> {

  private final RoomsMenu roomsMenu = new RoomsMenu();
  private final AddRoomMenu addRoomMenu = new AddRoomMenu();
  private final RentRoomMenu rentRoomMenu = new RentRoomMenu();
  private final ReturnRoomMenu returnRoomMenu = new ReturnRoomMenu();

  static String getPrompt(Hotel h) {
    return "\n" + h.getName() + "\n" +
      "- Total Rooms: " + h.getRoomCount() + ", Occupied: " + h.getOccupiedRooms() + "\n" +
      "- Open Standards: " + h.getAvailableStandards() + ", Open Suites: " + h.getAvailableSuites() + "\n" +
      "\nCLI-Menu\n" +
      "- 1: Examine rooms\n" +
      "- 2: Add a room\n" +
      "- 3: Rent a room\n" +
      "- 4: Return a room\n" +
      "- 0: Exit\n" +
      "\nEnter input: ";
  }

  public void drawMenu(Hotel trivago) {
    while(true) {
      switch(getNum(getPrompt(trivago), 0, 4)) {
        case 0: return;

        case 1:
          roomsMenu.drawMenu(trivago);
          break;

        case 2:
          addRoomMenu.drawMenu(trivago);
          break;

        case 3:
          rentRoomMenu.drawMenu(trivago);
          break;

        case 4:
          returnRoomMenu.drawMenu(trivago);
          break;
      }
    }
  }
}
