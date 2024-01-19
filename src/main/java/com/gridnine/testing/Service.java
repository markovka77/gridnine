package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Service {

    static LocalDateTime dateTimeNow = LocalDateTime.now();

    //получаем список результатов обработки тестового набора перелётов

    public static void outputTestSet() {
       FlightBuilder.createFlights()
               .forEach(System.out::println);
    }




    //выводим  список, в котором вылет до текущего момента времени

    public static void outputFlightWhereDepartureToTheCurrentPointInTime(List<Flight>allFls) {
        List<Flight> list1 = allFls.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate()
                                .isBefore(dateTimeNow)))
                .toList();
        System.out.println("Все полёты, кроме тех, в которых отправление раньше текущего времени:");
                allFls.stream()
                .filter(flight -> !flight.equals(list1.get(list1.size() - 1)))
                .toList().forEach(System.out::println);
    }

    //выводим список, в котором сегменты с датой прилёта раньше даты вылета

    public static void outputFlightWhereArrivalDateBeforeDepartureDate(List<Flight>allFls) {
        List<Flight> list2 = allFls.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate()
                                .isBefore(segment.getDepartureDate())))
                .toList();
        System.out.println("Все полёты, кроме тех, в которых отправление раньше даты прибытия: ");
        allFls.stream()
                .filter(flight -> !flight.equals(list2.get(list2.size()-1)))
                .toList().forEach(System.out::println);
    }


    //выводим список, перелетов, где общее время, проведённое на земле, превышает два часа

    public static void outputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours(List<Flight>allFls) {
        List<Flight> list3 = new ArrayList<>();
        for(Flight flight:allFls) {
            List<Segment> seg = flight.getSegments();
            for (int i = 0; i < seg.size()-1; i++) {
                if (seg.get(i + 1).getDepartureDate()
                        .isAfter(seg.get(i).getArrivalDate().plusHours(2))) {
                    list3.add(flight);
                }
            }
        }
        System.out.println("Все полёты,кроме тех, в которых общее время на земле 2 или более часов:");

        allFls.stream()
                .filter(flight -> !flight.equals(list3.get(list3.size()-1)))
                .toList().forEach(System.out::println);
    }


}
