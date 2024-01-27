package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для создания списока со всеми полетами,
 * кроме вылетов до текущего момента времени
 */
public class OutputFlightWhereDepartureToTheCurrentPointInTime implements FilterMethod {
    static LocalDateTime dateTimeNow = LocalDateTime.now();

    @Override
    public List<Flight> filter(List<Flight> allFls) {
        List<Flight> tmp = new ArrayList<>(List.copyOf(allFls));
        List<Flight> list1 = new ArrayList<>(allFls.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate()
                                .isBefore(dateTimeNow))).toList());
        System.out.println("Все полёты, кроме тех, в которых отправление раньше текущего времени:");
        tmp.removeAll(list1);
        tmp.forEach(System.out::println);
        return tmp;
    }
}
