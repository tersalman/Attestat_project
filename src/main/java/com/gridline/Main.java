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
        FilterForArrivingBeforeNow filterForArrivingBeforeNow = new FilterForArrivingBeforeNow();
        FilterForArrivingBeforeDeparture filterForArrivingBeforeDeparture = new FilterForArrivingBeforeDeparture();
        FilterForGroundTime filterForGroundTime = new FilterForGroundTime(120);
        // if you need print a filter in stages and use all filters in one click
        PrintFilteredFlights filterManager = new PrintFilteredFlights();
        filterManager.addFilter(new FilterForArrivingBeforeNow());
        filterManager.addFilter(new FilterForArrivingBeforeDeparture());
        filterManager.addFilter(new FilterForGroundTime(120)); // 2 hours

        //that all flights
        System.out.println(flights1);
        System.out.println("-------------------");
        //this is flights after using all filters
       filterManager.applyFilters(flights);

       // if you need to use each filter on e at time to use method (filter) in each one
        System.out.println(filterForArrivingBeforeDeparture.filter(flights));
        System.out.println("_______________________");
        System.out.println(filterForGroundTime.filter(flights));
        System.out.println("_______________________");
        System.out.println(filterForArrivingBeforeNow.filter(flights));







    }
}