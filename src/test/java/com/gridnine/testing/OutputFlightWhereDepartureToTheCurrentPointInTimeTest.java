package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputFlightWhereDepartureToTheCurrentPointInTimeTest {
    List<Flight> allFls = FlightBuilder.createFlights();
    OutputFlightWhereDepartureToTheCurrentPointInTime test =
            new OutputFlightWhereDepartureToTheCurrentPointInTime();

    @Test
    void filter() {
        List<Flight> actual = test.filter(allFls);

        assertNotNull(actual);
        assertNotSame(allFls, actual);
        assertNotEquals(allFls, actual);
        assert (actual.size() < allFls.size());

    }

}