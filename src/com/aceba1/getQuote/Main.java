package com.aceba1.getQuote;

public class Main {

    public static void main(String[] args) {
        Hotel trivago = new Hotel("Hotel Java",
          // Example rooms
          new StandardRoom(38000, 101, 2, 2),
          new StandardRoom(50000, 102, 2, 4),
          new SuiteRoom(70000, 103, 4, 2, false),
          new SuiteRoom(100000, 201, 4, 4, true));

        // CLI
        new Controller(trivago).cycle();
    }
}
