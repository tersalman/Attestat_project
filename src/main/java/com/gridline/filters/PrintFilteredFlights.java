package com.gridline.filters;

import com.gridline.Flight;

import java.util.ArrayList;
import java.util.List;

public class PrintFilteredFlights {
    private final List<FilterForFlights> filters = new ArrayList<>();

    public void addFilter(FilterForFlights filter) {
        filters.add(filter);
    }


    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = new ArrayList<>(flights);
        for (FilterForFlights filter : filters) {
            result = filter.filter(result);
        }
        return result;
    }

    public void printFiltered(List<Flight> flights) {
        flights.forEach(System.out::println);
    }

}
