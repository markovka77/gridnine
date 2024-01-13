package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {
        FlightBuilder.createFlights().stream()
                .forEach(System.out::println);
    }
}