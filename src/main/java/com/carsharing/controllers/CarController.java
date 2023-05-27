package com.carsharing.controllers;

import com.carsharing.models.Car;
import com.carsharing.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/v1/cars")
public class CarController {
    private final CarService carService;

    public CarController(
        CarService carService
    ) {
        this.carService = carService;
    }

    @GetMapping("")
    public List<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable long id) {
        return carService.findById(id);
    }

    @PostMapping("")
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping("/{id}")
    public Car update(
        @PathVariable long id,
        @RequestBody Car car
    ) {
        return carService.update(id, car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        carService.delete(id);
    }

    @GetMapping("/plate/{plate}")
    public Car findByPlate(@PathVariable String plate) {
        return carService.findByPlate(plate);
    }
}
