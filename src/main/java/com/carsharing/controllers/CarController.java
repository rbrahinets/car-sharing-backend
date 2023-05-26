package com.carsharing.controllers;

import com.carsharing.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/car")
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping()
    public String index(Model model) throws SQLException {
        model.addAttribute("cars", carRepository.index());
        return "car/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("car", carRepository.show(id));
        return "car/show";
    }

}
