package com.gridnine.testing;

public class Main {

    public static void main(String[] args) {
       Service.outputTestSet();
        System.out.println();
        System.out.println(Service.outputFlightWhereDepartureToTheCurrentPointInTime());
        System.out.println();
        System.out.println(Service.outputFlightWhereArrivalDateBeforeDepartureDate());
//        System.out.println(Service.outputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours());

    }

}