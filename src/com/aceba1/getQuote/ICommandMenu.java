package com.aceba1.getQuote;

import java.util.Scanner;

public interface ICommandMenu<T> {
  /**Display a list of numbers to choose from, as a loop with a switch case
   * @return only when menu is exited
   */
  void drawMenu(Controller controller, T context);
}
