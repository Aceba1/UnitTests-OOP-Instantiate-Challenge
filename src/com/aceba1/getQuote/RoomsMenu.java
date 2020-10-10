package com.aceba1.getQuote;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoomsMenu extends CommandMenu<Hotel> {

  String floorNamesCache;
  Map<Integer, List<Integer>> floorCache = null;

  private void setFloorNamesCache(){
    floorNamesCache = floorCache.keySet().stream()
      .map(Object::toString)
      .collect(Collectors.joining(", "));
  }

  static String getPrompt() {
    return "\nExamine-Rooms\n" +
      "- 1: By Room Number\n" +
      "- 2: Print Floors\n" +
      "- 0: Back\n" +
      "\nEnter input: ";
  }

  @Override
  void drawMenu(Hotel hotel) {
    if (hotel.getRoomCount() == 0) {
      System.out.println("\nExamine-Rooms\n...There are no rooms!");
      return;
    }
    while(true) {
      switch (getNum(getPrompt(), 0, 2)) {
        case 0 -> {
          floorCache = null;
          return;
        }
        case 1 -> {
          var room = hotel.getRoom(getNum("Room number: "));
          if (room == null)
            System.out.println("Room does not exist");
          else {
            System.out.println(room);
            if (room.isOccupied())
              System.out.println(room.getOccupant());
            else {
              if (room instanceof StandardRoom) {
                StandardRoom standardRoom = (StandardRoom) room;
                if (standardRoom.getNeedsCleaning() &&
                  getNum("Cleaned? (1-0): ", 0, 1) == 1)
                  standardRoom.clean();
              }
              if (room instanceof SuiteRoom) {
                SuiteRoom suiteRoom = (SuiteRoom) room;
                if (suiteRoom.getNeedsRestock() &&
                  getNum("Restocked? (1-0): ", 0, 1) == 1)
                  suiteRoom.restock();
              }
            }
          }
        }
        case 2 -> {
          if (floorCache == null) {
            floorCache = hotel.getFloors();
            setFloorNamesCache();
          }
          System.out.println("Floors: " + floorNamesCache);
          int floor;
          if (floorCache.size() != 1) {
            floor = getNum("\nFloor level: ");
          } else {
            floor = floorCache.keySet().stream().findFirst().get();
          }
          List<Integer> rooms = floorCache.get(floor);
          if (rooms == null)
            System.out.println("Floor " + floor + " undefined");
          else {
            System.out.println("\nRooms: " + rooms.size());
            for (Integer i : rooms) // Keep it in boxing
              System.out.println(hotel.getRoom(i));
          }
        }
      }
    }
  }
}
