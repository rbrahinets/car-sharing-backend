package com.carsharing.validators;

import com.carsharing.exceptions.NotFoundException;
import com.carsharing.exceptions.ValidationException;
import com.carsharing.models.Car;
import com.carsharing.models.Category;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarValidator {
    public void validate(Car car, List<Car> cars, List<Category> categories) {
        if (isBrandInvalid(car.getBrand())) {
            throw new ValidationException("Brand is invalid");
        } else if (isModelInvalid(car.getModel())) {
            throw new ValidationException("Model is invalid");
        } else if (isYearInvalid(car.getYear())) {
            throw new ValidationException("Year is invalid");
        } else if (isPriceInvalid(car.getPrice())) {
            throw new ValidationException("Price is invalid");
        } else if (isIdCategoryInvalid(car.getIdCategory(), categories)) {
            throw new ValidationException("Id of category is invalid");
        } else if (isInvalidPlate(car.getPlate())) {
            throw new ValidationException("Plate is invalid");
        } else if (isPlateAlreadyInUse(car.getPlate(), cars)) {
            throw new ValidationException("Plate is already in use");
        } else if (isImageInvalid(car.getImage())) {
            throw new ValidationException("Image is invalid");
        }
    }

    public void validate(long id, List<Car> cars) {
        List<Long> ids = new ArrayList<>();

        for (Car car : cars) {
            ids.add(car.getId());
        }

        if (!ids.contains(id)) {
            throw new NotFoundException("Car not found");
        }
    }

    public void validate(String plate, List<Car> cars) {
        if (!getPlates(cars).contains(plate)) {
            throw new NotFoundException("Car not found");
        }
    }

    private static boolean isBrandInvalid(String brand) {
        return brand == null
            || brand.isBlank();
    }

    private static boolean isModelInvalid(String model) {
        return model == null
            || model.isBlank();
    }

    private boolean isYearInvalid(int year) {
        return year < 1990 || year > Year.now().getValue();
    }

    private boolean isPriceInvalid(double price) {
        return price < 0;
    }

    private boolean isIdCategoryInvalid(long id, List<Category> categories) {
        List<Long> ids = new ArrayList<>();

        for (Category category : categories) {
            ids.add(category.getId());
        }

        return !ids.contains(id);
    }

    private boolean isInvalidPlate(String plate) {
        return plate == null
            || plate.isBlank();
    }

    private boolean isPlateAlreadyInUse(String plate, List<Car> cars) {
        return getPlates(cars).contains(plate);
    }

    private static boolean isImageInvalid(byte[] image) {
        return image.length == 0;
    }

    private static List<String> getPlates(List<Car> cars) {
        List<String> plates = new ArrayList<>();

        for (Car car : cars) {
            plates.add(car.getPlate());
        }
        return plates;
    }
}
