package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Класс для создания списока всех перелетов,
 * кроме тех ,где общее время, проведённое на земле,
 * два или более часа
 */
public class OutputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours implements FilterMethod {

    @Override
    public List<Flight> filter(List<Flight> allFls) {
        List<Flight> tmp = allFls.stream()
                .filter(flight -> TotalTime(flight) <= 2)
                .toList();
        tmp.forEach(System.out::println);
        return tmp;

    }


    private long TotalTime(Flight flight) {
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
