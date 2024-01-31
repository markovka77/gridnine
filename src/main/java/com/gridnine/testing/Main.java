package com.gridnine.testing;

import java.util.List;

public class Main {
    static FilterImpl filter = new FilterImpl();

    public static void main(String[] args) {
        List<Flight> allFls = FlightBuilder.createFlights();

        //получение списка полетов, кроме тех, в которых отправление раньше текущего времени
        filter.outPutFlightWhereDepartureToTheCurrentPointInTime(allFls);
        System.out.println();

        //получение списка полетов, кроме тех, в которых отправление раньше даты прибытия
        filter.outPutFlightWhereArrivalDateBeforeDepartureDate(allFls);
        System.out.println();

        //получение списка полетов, кроме тех, в которых общее время на земле 2 или более часов

        filter.outPutFlightWhereTotalTimeSpentOnEarthExceedsTwoHours(allFls);


    }


}