package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Flight> allFls = Service.outputTestSet();
        System.out.println(Service.outputTestSet());
        System.out.println();
        System.out.println(Service.outputFlightWhereDepartureToTheCurrentPointInTime(allFls));
        System.out.println();
        System.out.println(Service.outputFlightWhereArrivalDateBeforeDepartureDate(allFls));
        System.out.println();
        System.out.println(Service.outputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours(allFls));



    }

}