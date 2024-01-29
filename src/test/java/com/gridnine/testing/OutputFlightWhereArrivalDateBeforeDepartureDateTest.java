package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OutputFlightWhereArrivalDateBeforeDepartureDateTest {

    List<Flight> allFls = FlightBuilder.createFlights();
    OutputFlightWhereArrivalDateBeforeDepartureDate test =
            new OutputFlightWhereArrivalDateBeforeDepartureDate();



    @Test
    void filter() {
        List<Flight> actual = test.filter(allFls);
        assertNotNull(actual);
        assertNotEquals(allFls, actual);
        assert (actual.size() < allFls.size());

    }

}