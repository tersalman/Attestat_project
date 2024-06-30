package com.gridline.filters;

import com.gridline.Flight;

import java.util.List;

public interface FilterForFlights {
    List<Flight> filter(List<Flight> flights);
}
