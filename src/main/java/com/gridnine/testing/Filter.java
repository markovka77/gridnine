package com.gridnine.testing;

import java.util.List;

public interface Filter {

    List<Flight> outPutFlightWhereDepartureToTheCurrentPointInTime(List<Flight> allFls);

    List<Flight> outPutFlightWhereArrivalDateBeforeDepartureDate(List<Flight> allFls);

    List<Flight> outPutFlightWhereTotalTimeSpentOnEarthExceedsTwoHours(List<Flight> allFls);


}
