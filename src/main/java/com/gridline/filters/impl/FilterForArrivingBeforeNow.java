package com.gridline.filters.impl;

import com.gridline.Flight;
import com.gridline.filters.FilterForFlights;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for filter flights, if arriving is before now its will be not to showed
 */
public class FilterForArrivingBeforeNow implements FilterForFlights {
    /**
     * method which accept a list of flights and if arriving before now is will be not returned in list
     * @param flights
     * @return List of flights
     */
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
