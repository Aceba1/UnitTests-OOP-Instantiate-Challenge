package com.aceba1.getQuote;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Hotel {

  String name = "Hotel Java";
  int rooms = 0;

  List<StandardRoom> availableStandards = new ArrayList<>();
  List<StandardRoom> reservedStandards = new ArrayList<>();
  List<SuiteRoom> availableSuites = new ArrayList<>();
  List<SuiteRoom> reservedSuites = new ArrayList<>();
  List<Client> clients = new ArrayList<>();

  public Hotel(String name, Room... rooms) {
    for (var room : rooms) {
      addRoom(room);
    }
  }

  public void addRoom(Room room) {
    if (room.getType().equals("suite")) {
      availableSuites.add((SuiteRoom) room);
    } else {
      availableStandards.add((StandardRoom) room);
    }
    rooms++;
  }

  public void reserveRoom(Room room, Client client) {
    try {
      Room reserve;
      if (room.getType().equals("suite")) {
        reserve = getFirst(availableSuites, room);
        if (reserve.reserve(client)) {
          reservedSuites.add((SuiteRoom) reserve);
          availableSuites.remove(reserve);
        }
      } else {
        reserve = getFirst(availableStandards, room);
        if (reserve.reserve(client)) {
          reservedStandards.add((StandardRoom) reserve);
          availableStandards.remove(reserve);
        }
      }
    } catch(NoSuchElementException E) {
      System.out.println("Unavailable: Room does not exist");
    }
  }

  public void checkoutRoom(Room room) {
    Room reserve;
    if (room.getType().equals("suite")) {
      reserve = getFirst(availableSuites, room);
      reserve.checkout();
      reservedSuites.add((SuiteRoom) reserve);
      availableSuites.remove(reserve);
    } else {
      reserve = getFirst(availableStandards, room);
      reserve.checkout();
      reservedStandards.add((StandardRoom) reserve);
      availableStandards.remove(reserve);
    }
  }

  private static <T extends Room> Room  getFirst(List<T> list, Room comparison) {
    return list.stream()
      .filter(r -> r.equals(comparison))
      .findFirst()
      .get();
  }

  public String getName() {
    return name;
  }

  public int getRooms() {
    return rooms;
  }

  @Override
  public String toString() {
    return "Hotel{" +
      "name='" + name + '\'' +
      ", rooms=" + rooms +
      ", availableStandards=" + availableStandards +
      ", reservedStandards=" + reservedStandards +
      ", availableSuites=" + availableSuites +
      ", reservedSuites=" + reservedSuites +
      ", clients=" + clients +
      '}';
  }
}
