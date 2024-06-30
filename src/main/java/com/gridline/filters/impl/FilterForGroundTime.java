package com.gridline.filters.impl;

import com.gridline.Flight;
import com.gridline.Segment;
import com.gridline.filters.FilterForFlights;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class FilterForGroundTime implements FilterForFlights {
    private final long maxGroundTimeMinutes;

    public FilterForGroundTime(long maxGroundTimeMinutes) {
        this.maxGroundTimeMinutes = maxGroundTimeMinutes;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    for (int i = 0; i < segments.size() - 1; i++) {
                        Segment current = segments.get(i);
                        Segment next = segments.get(i + 1);
                        long groundTime = Duration.between(current.getArrivalDate(), next.getDepartureDate()).toMinutes();
                        if (groundTime > maxGroundTimeMinutes) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}
