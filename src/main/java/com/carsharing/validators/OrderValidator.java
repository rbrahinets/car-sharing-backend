package com.carsharing.validators;

import com.carsharing.exceptions.NotFoundException;
import com.carsharing.exceptions.ValidationException;
import com.carsharing.models.Car;
import com.carsharing.models.Order;
import com.carsharing.models.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderValidator {
    public void validate(Order order, List<Order> orders, List<Car> cars, List<Status> statuses) {
        if (isInvalidIdCar(order.getIdCar(), cars)) {
            throw new ValidationException("Id of car is invalid");
        } else if (isInvalidEmail(order.getEmail())) {
            throw new ValidationException("E-mail is invalid");
        } else if (isAmountPriceInvalid(order.getAmountPrice())) {
            throw new ValidationException("Amount price is invalid");
        } else if (isRentalDateInvalid(order.getRentalDate())) {
            throw new ValidationException("Rental date is invalid");
        } else if (isReturnDateInvalid(order.getReturnDate())) {
            throw new ValidationException("Return date is invalid");
        } else if (isInvalidIdStatus(order.getIdStatus(), statuses)) {
            throw new ValidationException("Id of status is invalid");
        }
    }

    public void validate(long id, List<Order> orders) {
        List<Long> ids = new ArrayList<>();

        for (Order order : orders) {
            ids.add(order.getId());
        }

        if (!ids.contains(id)) {
            throw new NotFoundException("Order not found");
        }
    }

    public void validate(String email, List<Order> orders) {
        if (!getEmails(orders).contains(email)) {
            throw new NotFoundException("Order not found");
        }
    }

    private boolean isInvalidIdCar(long id, List<Car> cars) {
        List<Long> ids = new ArrayList<>();

        for (Car car : cars) {
            ids.add(car.getId());
        }

        return !ids.contains(id);
    }

    private boolean isInvalidEmail(String email) {
        return email == null
            || email.isBlank()
            || email.startsWith("@")
            || email.endsWith("@.com")
            || !email.endsWith(".com");
    }

    private static boolean isAmountPriceInvalid(double amountPrice) {
        return amountPrice < 0;
    }

    private boolean isRentalDateInvalid(LocalDateTime rentalDate) {
        return LocalDateTime.now().isAfter(rentalDate);
    }

    private boolean isReturnDateInvalid(LocalDateTime returnDate) {
        return LocalDateTime.now().isEqual(returnDate)
            || LocalDateTime.now().isAfter(returnDate);
    }

    private boolean isInvalidIdStatus(long id, List<Status> statuses) {
        List<Long> ids = new ArrayList<>();

        for (Status status : statuses) {
            ids.add(status.getId());
        }

        return !ids.contains(id);
    }

    private static List<String> getEmails(List<Order> orders) {
        List<String> emails = new ArrayList<>();

        for (Order order : orders) {
            emails.add(order.getEmail());
        }
        return emails;
    }
}
