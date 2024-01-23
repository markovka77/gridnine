package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для вывода списка всех полетов, кроме тех,
 * в которых сегменты с датой прилёта раньше даты вылета
 */
public class OutputFlightWhereArrivalDateBeforeDepartureDate implements FilterMethod {
    @Override
    public List<Flight> filter(List<Flight> allFls) {
        List<Flight> test = new ArrayList<>(allFls);
        List<Flight> list2 = new ArrayList<>(allFls.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate()
                                .isBefore(segment.getDepartureDate())))
                .toList());
        System.out.println("Все полёты, кроме тех, в которых отправление раньше даты прибытия: ");
        test.removeAll(list2);
        test.forEach(System.out::println);
        return test;
    }
}
