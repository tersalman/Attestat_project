package com.gridline.filters.impl;

import com.gridline.Flight;
import com.gridline.filters.FilterForFlights;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FilterForArrivingBeforeNow implements FilterForFlights {
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
