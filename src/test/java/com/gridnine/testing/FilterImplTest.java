package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterImplTest {
    static List<Flight> allFls = FlightBuilder.createFlights();
    static FilterImpl filter = new FilterImpl();


    @Test
    void outPutFlightWhereDepartureToTheCurrentPointInTime() {
        List<Flight> actual = filter.outPutFlightWhereDepartureToTheCurrentPointInTime(allFls);

        assertNotNull(actual);
        assertNotSame(allFls, actual);
        assertNotEquals(allFls, actual);
        assert (actual.size() < allFls.size());
    }

    @Test
    void outputFlightWhereArrivalDateBeforeDepartureDate() {
        List<Flight> actual = filter.outPutFlightWhereArrivalDateBeforeDepartureDate(allFls);
        assertNotNull(actual);
        assertNotEquals(allFls, actual);
        assert (actual.size() < allFls.size());
    }

    @Test
    void outputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours() {
        List<Flight> actual = filter.outPutFlightWhereTotalTimeSpentOnEarthExceedsTwoHours(allFls);

        assertNotNull(actual);
        assertNotSame(allFls, actual);
        assertNotEquals(allFls, actual);
        assert (actual.size() < allFls.size());
    }
}