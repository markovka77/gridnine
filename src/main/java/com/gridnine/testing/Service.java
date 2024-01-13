package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    public static LocalDateTime dateTimeNow = LocalDateTime.now();
    static void outputTestSet(){
        //вывод в консоль результатов обработки тестового набора перелётов
        FlightBuilder.createFlights()
                .forEach(System.out::println);
    }
    static List<Flight> outputFlightWhereDepartureToTheCurrentPointInTime(){
       return FlightBuilder.createFlights().stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate()
                                .isBefore(dateTimeNow)))
               .collect(Collectors.toList());


    }
}
