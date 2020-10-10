package com.aceba1.getQuote;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class CommandMenu<T> {

  static protected final Scanner sc = new Scanner(System.in);

  /**Display a list of numbers to choose from, as a loop with a switch case.
   * Returns only when done
   */
  abstract void drawMenu(T context);

  public static void flush() {
    //if (sc.hasNextLine())
      sc.nextLine();
  }

  public static int getNum(String promptNoLine) {
    while (true) {
      System.out.print(promptNoLine);
      try {
        int value = sc.nextInt();
        flush(); return value;
      } catch(InputMismatchException e) {
        System.out.println("Not a number");
        flush();
      }
    }
  }

  public static int getNum(String promptNoLine, int min, int max) {
    while (true) {
      int val = getNum(promptNoLine);
      if (val >= min && val <= max) return val;
      System.out.println("Input out of range (" + min + ", " + max + ")");
    }
  }

  public static String getLine(String promptNoLine) {
    System.out.print(promptNoLine);
    return sc.nextLine().trim().toLowerCase();
  }


  public static String getLine(String promptNoLine, String regex) {
    while (true) {
      String value = getLine(promptNoLine);
      if (value.matches(regex)) return value;
      System.out.println("Invalid input");
    }
  }
}
