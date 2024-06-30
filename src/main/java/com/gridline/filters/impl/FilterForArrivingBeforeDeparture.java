package com.gridline.filters.impl;

import com.gridline.Flight;
import com.gridline.filters.FilterForFlights;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for filter flights, if arriving be before departure it's will not be show at the screen
 */
public class FilterForArrivingBeforeDeparture implements FilterForFlights {

    /**
     * method which accept a list of flights and if arriving before departure is will be not returned in list
     * @param flights
     * @return List of flights
     */
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
