package com.gridnine.testing;

public class Service {

    //получаем список результатов обработки тестового набора перелётов
    public static void outputTestSet() {
        FlightBuilder.createFlights()
                .forEach(System.out::println);
    }


}
