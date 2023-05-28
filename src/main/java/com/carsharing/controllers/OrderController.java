package com.carsharing.controllers;

import com.carsharing.models.Order;
import com.carsharing.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(
        OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable long id) {
        return orderService.findById(id);
    }

    @PostMapping("")
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    public Order update(
        @PathVariable long id,
        @RequestBody Order order
    ) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        orderService.delete(id);
    }

    @GetMapping("/email/{email}")
    public Order findByEmail(@PathVariable String email) {
        return orderService.findByEmail(email);
    }
}
