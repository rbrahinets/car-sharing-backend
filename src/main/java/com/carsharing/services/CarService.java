package com.carsharing.services;

import com.carsharing.models.Car;
import com.carsharing.repositories.CarRepository;
import com.carsharing.repositories.CategoryRepository;
import com.carsharing.validators.CarValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CategoryRepository categoryRepository;
    private final CarValidator carValidator;

    public CarService(
        CarRepository carRepository,
        CategoryRepository categoryRepository,
        CarValidator carValidator
    ) {
        this.carRepository = carRepository;
        this.categoryRepository = categoryRepository;
        this.carValidator = carValidator;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(long id) {
        carValidator.validate(id, carRepository.findAll());
        return carRepository.findById(id).orElseThrow();
    }

    public Car save(Car car) {
        carValidator.validate(
            car,
            carRepository.findAll(),
            categoryRepository.findAll()
        );
        carRepository.save(car);
        return car;
    }

    public Car update(long id, Car car) {
        carValidator.validate(id, carRepository.findAll());
        carRepository.update(id, car);
        return car;
    }

    public void delete(long id) {
        carValidator.validate(id, carRepository.findAll());
        carRepository.delete(id);
    }

    public Car findByPlate(String plate) {
        carValidator.validate(plate, carRepository.findAll());
        return carRepository.findByPlate(plate).orElseThrow();
    }
}
