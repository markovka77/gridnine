package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FilterImpl implements Filter {
    static LocalDateTime dateTimeNow = LocalDateTime.now();


    @Override
    public List<Flight> outPutFlightWhereDepartureToTheCurrentPointInTime(List<Flight> allFls) {
        List<Flight> filteredList = new ArrayList<>(List.copyOf(allFls));
        List<Flight> list1 = new ArrayList<>(allFls.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate()
                                .isBefore(dateTimeNow))).toList());
        System.out.println("Все полёты, кроме тех, в которых отправление раньше текущего времени:");
        filteredList.removeAll(list1);

        filteredList.forEach(System.out::println);

        return filteredList;
    }

    @Override
    public List<Flight> outPutFlightWhereArrivalDateBeforeDepartureDate(List<Flight> allFls) {
        List<Flight> filteredList = new ArrayList<>(List.copyOf(allFls));
        List<Flight> list2 = new ArrayList<>(allFls.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate()
                                .isBefore(segment.getDepartureDate())))
                .toList());
        System.out.println("Все полёты, кроме тех, в которых отправление раньше даты прибытия: ");
        filteredList.removeAll(list2);
        filteredList.forEach(System.out::println);
        return filteredList;
    }

    @Override
    public List<Flight> outPutFlightWhereTotalTimeSpentOnEarthExceedsTwoHours(List<Flight> allFls) {
        List<Flight> filteredList = allFls.stream()
                .filter(flight -> getTotalTime(flight) <= 2)
                .toList();
        System.out.println("Все полёты, кроме тех, в которых общее время на земле 2 или более часов:");
        filteredList.forEach(System.out::println);
        return filteredList;
    }

    private long getTotalTime(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long totalTime = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime timeArrival = segments.get(i).getArrivalDate();
            LocalDateTime timeDeparture = segments.get(i + 1).getDepartureDate();
            totalTime += ChronoUnit.HOURS.between(timeArrival, timeDeparture);
        }
        return totalTime;
    }


}
