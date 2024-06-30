package com.gridline.filters.impl;

import com.gridline.Flight;
import com.gridline.filters.FilterForFlights;

import java.util.List;
import java.util.stream.Collectors;

public class FilterForArrivingBeforeDeparture implements FilterForFlights {
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
