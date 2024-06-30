package com.gridline.filters;

import com.gridline.Flight;

import java.util.ArrayList;
import java.util.List;

/**
 * It's a class which manage other filters and print it after that
 */
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
        printFiltered(result);
        return result;
    }

    public void printFiltered(List<Flight> flights) {
        System.out.println(flights);;
    }

}
