package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<Flight>allFls = FlightBuilder.createFlights();
//       Service.outputFlightWhereDepartureToTheCurrentPointInTime(allFls);
       Service.outputFlightWhereArrivalDateBeforeDepartureDate(allFls);
      // Service.outputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours(allFls);


    }




}