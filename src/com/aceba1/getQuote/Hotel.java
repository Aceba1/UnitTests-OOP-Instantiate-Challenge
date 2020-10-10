package com.aceba1.getQuote;

import java.util.*;
import java.util.stream.Collectors;

public class Hotel {

  String name;
  int roomCount;

  Map<Integer, Room> allRooms = new HashMap<>();
  List<StandardRoom> availableStandards = new ArrayList<>();
  List<StandardRoom> reservedStandards = new ArrayList<>();
  List<SuiteRoom> availableSuites = new ArrayList<>();
  List<SuiteRoom> reservedSuites = new ArrayList<>();
  List<Client> clients = new ArrayList<>();

  public Hotel(String name, Room... rooms) {
    this.name = name;
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
    allRooms.put(room.number, room);
    roomCount++;
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

  public Room getRoom(int number) {
    return allRooms.get(number);
  }

  public boolean hasRoom(int number) {
    return allRooms.containsKey(number);
  }

  public Room getRoom(Integer number) {
    return allRooms.get(number);
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
      .orElse(null);
  }

  public Map<Integer, List<Integer>> getFloors() {
    return allRooms.keySet().stream()
      .collect(Collectors.groupingBy(r -> r / 100));
  }

  public List<Integer> getFloor(int floor) {
    return allRooms.keySet().stream()
      .filter(r -> (r / 100) == floor)
      .collect(Collectors.toList());
  }

  public String getName() {
    return name;
  }

  public int getRoomCount() {
    return roomCount;
  }

  public int getOccupiedRooms() {
    return reservedSuites.size() + reservedStandards.size();
  }

  public int getAvailableRooms() {
    return availableSuites.size() + availableStandards.size();
  }

  public int getAvailableStandards() {
    return availableStandards.size();
  }

  public int getAvailableSuites() {
    return availableSuites.size();
  }

  @Override
  public String toString() {
    return "Hotel{" +
      "name='" + name + '\'' +
      ", rooms=" + roomCount +
      ", availableStandards=" + availableStandards +
      ", reservedStandards=" + reservedStandards +
      ", availableSuites=" + availableSuites +
      ", reservedSuites=" + reservedSuites +
      ", clients=" + clients +
      '}';
  }
}
