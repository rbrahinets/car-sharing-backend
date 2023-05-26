package com.carsharing.repositories;

import com.carsharing.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrderRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM `order`",
            new BeanPropertyRowMapper<>(Order.class)
        );
    }

    public Optional<Order> findById(long id) {
        return jdbcTemplate.query(
                "SELECT * FROM `order` WHERE id=:id",
                Map.ofEntries(Map.entry("id", id)),
                new BeanPropertyRowMapper<>(Order.class)
            )
            .stream().findAny();
    }

    public void save(Order order) {
        jdbcTemplate.update(
            "INSERT INTO `order` (id_car, email, amount_price, rental_date, return_date, id_status)"
                + "VALUES (:first_name, :email, :amount_price, :rental_date, :return_date, :id_status)",
            Map.ofEntries(
                Map.entry("id_car", order.getIdCar()),
                Map.entry("email", order.getEmail()),
                Map.entry("amount_price", order.getAmountPrice()),
                Map.entry("rental_date", order.getRentalDate()),
                Map.entry("return_date", order.getReturnDate()),
                Map.entry("id_status", order.getIdStatus())
            )
        );
    }

    public void update(long id, Order order) {
        jdbcTemplate.update(
            "UPDATE `order`" +
                " SET id_car=:id_car, email=:email, amount_price=:amount_price," +
                " rental_date=:rental_date, return_date=:return_date, id_status=:id_status" +
                " WHERE id=:id",
            Map.ofEntries(
                Map.entry("id_car", order.getIdCar()),
                Map.entry("email", order.getEmail()),
                Map.entry("amount_price", order.getAmountPrice()),
                Map.entry("rental_date", order.getRentalDate()),
                Map.entry("return_date", order.getReturnDate()),
                Map.entry("id_status", order.getIdStatus()),
                Map.entry("id", id)
            )
        );
    }

    public void delete(Order order) {
        jdbcTemplate.update(
            "DELETE FROM `order` WHERE id=:id",
            Map.ofEntries(Map.entry("id", order.getId()))
        );
    }

    public Optional<Order> findByEmail(String email) {
        return jdbcTemplate.query(
                "SELECT * FROM `order` WHERE email=:email",
                Map.ofEntries(Map.entry("email", email)),
                new BeanPropertyRowMapper<>(Order.class)
            )
            .stream().findAny();
    }
}
