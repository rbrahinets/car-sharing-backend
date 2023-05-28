package com.carsharing.services;

import com.carsharing.models.Order;
import com.carsharing.repositories.CarRepository;
import com.carsharing.repositories.OrderRepository;
import com.carsharing.repositories.StatusRepository;
import com.carsharing.validators.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CarRepository carRepository;
    private final StatusRepository statusRepository;
    private final OrderValidator orderValidator;

    public OrderService(
        OrderRepository orderRepository,
        CarRepository carRepository,
        StatusRepository statusRepository,
        OrderValidator orderValidator
    ) {
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
        this.statusRepository = statusRepository;
        this.orderValidator = orderValidator;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(long id) {
        orderValidator.validate(id, orderRepository.findAll());
        return orderRepository.findById(id).orElseThrow();
    }

    public Order save(Order order) {
        orderValidator.validate(
            order,
            orderRepository.findAll(),
            carRepository.findAll(),
            statusRepository.findAll()
        );
        orderRepository.save(order);
        return order;
    }

    public Order update(long id, Order order) {
        orderValidator.validate(id, orderRepository.findAll());
        orderRepository.update(id, order);
        return order;
    }

    public void delete(long id) {
        orderValidator.validate(id, orderRepository.findAll());
        orderRepository.delete(id);
    }

    public Order findByEmail(String email) {
        orderValidator.validate(email, orderRepository.findAll());
        return orderRepository.findByEmail(email).orElseThrow();
    }
}
