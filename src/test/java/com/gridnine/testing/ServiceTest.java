package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {


    @Test
    void outputTestSet() {
        List<Flight> allFls = FlightBuilder.createFlights()
                .stream().toList();
        List<Flight> test = Service.outputTestSet();
        assertEquals(test.size(),allFls.size());
    }

    @Test
    void outputFlightWhereDepartureToTheCurrentPointInTime() {
    }

    @Test
    void outputFlightWhereArrivalDateBeforeDepartureDate() {
    }

    @Test
    void outputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours() {
    }
}