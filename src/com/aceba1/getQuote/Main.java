package com.aceba1.getQuote;

public class Main {



    public static void main(String[] args) {
	// write your code here
        Hotel trivago = new Hotel("Hotel Java");
        new Controller(trivago).cycle();
    }
}
