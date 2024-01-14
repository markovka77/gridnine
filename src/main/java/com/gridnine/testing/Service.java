package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    static LocalDateTime dateTimeNow = LocalDateTime.now();

    static void outputTestSet() {
        //вывод в консоль результатов обработки тестового набора перелётов
        FlightBuilder.createFlights()
                .forEach(System.out::println);
    }

    static List<Flight> outputFlightWhereDepartureToTheCurrentPointInTime() {
        return FlightBuilder.createFlights().stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate()
                                .isBefore(dateTimeNow)))
                .collect(Collectors.toList());
    }

    static List<Flight> outputFlightWhereArrivalDateBeforeDepartureDate() {
        return FlightBuilder.createFlights().stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate()
                                .isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }

//    static List<Flight> outputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours() {
//      List<Flight> twoHoursAtEarth = FlightBuilder.createFlights().stream()
//              .filter(flight -> flight.getSegments().size()>=2).toList();
//
//       List<Segment>segments = twoHoursAtEarth.stream().filter(flight -> flight.getSegments().stream()
//                       .allMatch(segment -> segment.getArrivalDate().plusHours(2).isAfter(segment.getDepartureDate())))
//               .
//
//
//       return FlightBuilder.createFlights().stream()
//                .filter(flight -> flight.getSegments().stream()
//                        .anyMatch(segment -> segment.getArrivalDate().plusHours(2)
//                                .isAfter(segment.getDepartureDate())))
//               .collect(Collectors.toList());
//    }

}
