package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> allFls = FlightBuilder.createFlights();
        //получение списка всех полетов
        System.out.println("Список всех полетов :");
        System.out.println(allFls);
        System.out.println();

        //получение списка полетов с фильтром 1
        OutputFlightWhereArrivalDateBeforeDepartureDate listFlights1 =
                new OutputFlightWhereArrivalDateBeforeDepartureDate();
        listFlights1.filter(allFls);

        System.out.println();

        //получение списка полетов с фильтром 2
        OutputFlightWhereDepartureToTheCurrentPointInTime listFlights2 =
                new OutputFlightWhereDepartureToTheCurrentPointInTime();
        listFlights2.filter(allFls);

        System.out.println();

        //получение списка полетов с фильтром 3
        System.out.println("Все полёты,кроме тех, в которых общее время на земле 2 или более часов:");
        OutputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours listFlights3 =
                new OutputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours();
        listFlights3.filter(allFls);


    }


}