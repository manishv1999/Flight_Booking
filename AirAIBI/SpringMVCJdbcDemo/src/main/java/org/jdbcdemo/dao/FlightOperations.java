package org.jdbcdemo.dao;

import org.jdbcdemo.model.Flight;

import java.util.List;

public interface FlightOperations {
    public boolean create(Flight flight);

    public Flight read(String flightCode, String flightNumber);

    public boolean update(String flightCode, String flightNumber);

    public boolean delete(String flightCode, String flightNumber);

    public List<Flight> readAll();
}
