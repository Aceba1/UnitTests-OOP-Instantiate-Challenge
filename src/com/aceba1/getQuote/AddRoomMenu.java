package com.aceba1.getQuote;

public class AddRoomMenu extends CommandMenu<Hotel> {

  static StandardRoom createStandardRoom(int number) {
    int price = getNum("Pricing: $", 15, 1000000);
    int roomCount = getNum("Room Count: ", 1, 16);
    int bedCount = getNum("Total beds: ", 1, 32);
    return new StandardRoom(
      price,
      number,
      number / 100,
      roomCount,
      bedCount);
  }

  static SuiteRoom createSuiteRoom(int number) {
    int price = getNum("Pricing: $", 15, 1000000);
    int roomCount = getNum("Room Count: ", 1, 16);
    int bedCount = getNum("Total Beds: ", 1, 32);
    int kitchenette = getNum("Kitchenette? (1-0): ", 0, 1);
    return new SuiteRoom(
      price,
      number,
      number / 100,
      roomCount,
      bedCount,
      kitchenette == 1);
  }

  @Override
  void drawMenu(Hotel hotel) {
    System.out.println("\nAdd-Room");
    int roomNumber;
    while (true) {
      roomNumber = getNum("Enter room number: ", 0, 999);
      if (roomNumber == 0) return;
      if (roomNumber < 100) {
        System.out.println("Room number cannot be below 100!");
        continue;
      }
      if (hotel.hasRoom(roomNumber)) {
        System.out.println("Room already exists!");
        continue;
      }
      break;
    }
    Room room;
    switch (getNum("\nRoom types\n" +
      "- 1: Standard\n" +
      "- 2: Suite\n\n" +
      "Enter room type: ", 0, 2)) {
      case 1:
        room = createStandardRoom(roomNumber);
        break;
      case 2:
        room = createSuiteRoom(roomNumber);
        break;
      case 0: default: // Default is here to remove uninitialized warning below
        return;
    }
    hotel.addRoom(room);
    System.out.println("Added room to hotel!");
  }
}
