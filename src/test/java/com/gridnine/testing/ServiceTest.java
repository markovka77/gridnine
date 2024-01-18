package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static jdk.dynalink.linker.support.Guards.isNotNull;
import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    static List<Flight> allFls = FlightBuilder.createFlights()
            .stream().toList();

    @Test
    void outputTestSet() {
        List<Flight> test = Service.outputTestSet();
        assertEquals(test.size(),allFls.size());
    }

    @Test
    void outputFlightWhereDepartureToTheCurrentPointInTime() {
        assertNotNull(
                Service.outputFlightWhereDepartureToTheCurrentPointInTime(allFls)
        );

    }

    @Test
    void outputFlightWhereArrivalDateBeforeDepartureDate() {
        assertNotNull(
                Service.outputFlightWhereArrivalDateBeforeDepartureDate(allFls)
        );
    }

    @Test
    void outputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours() {
        assertNotNull(
                Service.outputFlightWhereTotalTimeSpentOnEarthExceedsTwoHours(allFls)
        );
    }


}