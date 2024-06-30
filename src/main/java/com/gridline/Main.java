package com.gridline;

import com.gridline.filters.PrintFilteredFlights;
import com.gridline.filters.impl.FilterForArrivingBeforeDeparture;
import com.gridline.filters.impl.FilterForArrivingBeforeNow;
import com.gridline.filters.impl.FilterForGroundTime;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> flights1 = FlightBuilder.createFlights();

        PrintFilteredFlights filterManager = new PrintFilteredFlights();
        filterManager.addFilter(new FilterForArrivingBeforeNow());
        filterManager.addFilter(new FilterForArrivingBeforeDeparture());
        filterManager.addFilter(new FilterForGroundTime(120)); // 2 hours

        List<Flight> filteredFlights = filterManager.filter(flights);

        System.out.println(filteredFlights);
        System.out.println(flights1);




    }
}