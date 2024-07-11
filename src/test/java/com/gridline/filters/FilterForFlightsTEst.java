package com.gridline.filters;

import com.gridline.Flight;
import com.gridline.FlightBuilder;
import com.gridline.filters.FilterForFlights;
import com.gridline.filters.impl.FilterForArrivingBeforeDeparture;
import com.gridline.filters.impl.FilterForArrivingBeforeNow;
import com.gridline.filters.impl.FilterForGroundTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterForFlightsTEst {
    private List<Flight> flights;

    @BeforeEach

    void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    void testDepartureAfterNowFilter() {
        FilterForFlights filter = new FilterForArrivingBeforeNow();
        List<Flight> filteredFlights = filter.filter(flights);
        assertEquals(5, filteredFlights.size());
    }

    @Test
    void testArrivalAfterDepartureFilter() {
        FilterForFlights filter = new FilterForArrivingBeforeDeparture();
        List<Flight> filteredFlights = filter.filter(flights);
        assertEquals(5, filteredFlights.size());
    }

    @Test
    void testMaxGroundTimeFilter() {
        FilterForFlights filter = new FilterForGroundTime(120);
        List<Flight> filteredFlights = filter.filter(flights);
        assertEquals(4, filteredFlights.size());
    }

    @Test
    void testFlightFilterManager() {
        PrintFilteredFlights filterManager = new PrintFilteredFlights();
        filterManager.addFilter(new FilterForArrivingBeforeNow());
        filterManager.addFilter(new FilterForArrivingBeforeDeparture());
        filterManager.addFilter(new FilterForGroundTime(120));

        List<Flight> filteredFlights = filterManager.filter(flights);
        assertEquals(2, filteredFlights.size());
    }
}
