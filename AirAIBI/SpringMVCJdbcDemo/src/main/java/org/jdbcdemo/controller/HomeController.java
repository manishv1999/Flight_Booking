package org.jdbcdemo.controller;

import org.jdbcdemo.dao.FlightOperations;
import org.jdbcdemo.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    FlightOperations flightOperations;

    @RequestMapping(value = "/")
    public ModelAndView test(HttpServletResponse response) throws IOException {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/flightoperations")
    public String flightoperations(Model model) throws IOException {
        model.addAttribute("Flight", new Flight());
        List<Flight> flightList = flightOperations.readAll();
        model.addAttribute("flightList", flightList);
        return "flightoperations";
    }

    @RequestMapping(value = "/createflight")
    public ModelAndView createFlight(@ModelAttribute("Flight") Flight flight) throws IOException {
        flightOperations.create(flight);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("flightoperations");
        List<Flight> flightList = flightOperations.readAll();
        mv.addObject("flightList", flightList);
        return mv;
    }
}



