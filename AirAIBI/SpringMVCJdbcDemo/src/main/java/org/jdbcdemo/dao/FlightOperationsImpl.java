package org.jdbcdemo.dao;

import org.jdbcdemo.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FlightOperationsImpl implements FlightOperations{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean create(Flight flight) {
        System.out.println("inside create flight operation");
        String sql = "insert into flight values (default, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, flight.getFlightCode(),flight.getFlightNumber(),flight.getDepartureAirport(),flight.getArrivalAirport());
        return false;
    }

    @Override
    public Flight read(String flightCode, String flightNumber) {
        return null;
    }

    @Override
    public boolean update(String flightCode, String flightNumber) {
        return false;
    }

    @Override
    public boolean delete(String flightCode, String flightNumber) {
        return false;
    }

    @Override
    public List<Flight> readAll() {
        String sql="select * from flight";
        List<Flight> flightList = jdbcTemplate.query(sql, new RowMapper<Flight>() {
            @Override
            public Flight mapRow(ResultSet resultSet, int i) throws SQLException {
                Flight flight =new Flight();
                flight.setFlightCode(resultSet.getString("flight_code"));
                flight.setFlightNumber(resultSet.getString("flight_number"));
                flight.setDepartureAirport(resultSet.getString("departure_airport"));
                flight.setArrivalAirport(resultSet.getString("arrival_airport"));
                flight.setRowId(resultSet.getInt("row_id"));
                return flight;
            }
        });

        return flightList;
    }
}
