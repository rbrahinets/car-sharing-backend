package com.carsharing.repositories;

import com.carsharing.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CarRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CarRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM `car`",
            new BeanPropertyRowMapper<>(Car.class)
        );
    }

    public Optional<Car> findById(long id) {
        return jdbcTemplate.query(
                "SELECT * FROM `car` WHERE id=:id",
                Map.ofEntries(Map.entry("id", id)),
                new BeanPropertyRowMapper<>(Car.class)
            )
            .stream().findAny();
    }

    public void save(Car car) {
        jdbcTemplate.update(
            "INSERT INTO `car` (brand, model, year, price, id_category, plate, image)"
                + " VALUES (:brand, :model, :year, :price, :id_category, :plate, :available, :image)",
            Map.ofEntries(
                Map.entry("brand", car.getBrand()),
                Map.entry("model", car.getModel()),
                Map.entry("year", car.getYear()),
                Map.entry("price", car.getPrice()),
                Map.entry("id_category", car.getIdCategory()),
                Map.entry("plate", car.getPlate()),
                Map.entry("available", car.isAvailable()),
                Map.entry("image", car.getImage())
            )
        );
    }

    public void update(long id, Car car) {
        jdbcTemplate.update(
            "UPDATE `car`" +
                " SET brand=:brand, model=:model, year=:year, price=:price," +
                " id_category=:id_category, plate:=plate, available=:avaliable, image:=image" +
                " WHERE id=:id",
            Map.ofEntries(
                Map.entry("brand", car.getBrand()),
                Map.entry("model", car.getModel()),
                Map.entry("year", car.getYear()),
                Map.entry("price", car.getPrice()),
                Map.entry("id_category", car.getIdCategory()),
                Map.entry("plate", car.getPlate()),
                Map.entry("available", car.isAvailable()),
                Map.entry("image", car.getImage()),
                Map.entry("id", id)
            )
        );
    }

    public void delete(Car car) {
        jdbcTemplate.update(
            "DELETE FROM `car` WHERE id=:id",
            Map.ofEntries(Map.entry("id", car.getId()))
        );
    }

    public Optional<Car> findByPlate(String plate) {
        return jdbcTemplate.query(
                "SELECT * FROM `car` WHERE plate=:plate",
                Map.ofEntries(Map.entry("plate", plate)),
                new BeanPropertyRowMapper<>(Car.class)
            )
            .stream().findAny();
    }

    public void saveImageForCar(byte[] image, long id) {
        jdbcTemplate.update(
            "UPDATE `car` SET image=:image WHERE id=:id",
            Map.ofEntries(
                Map.entry("image", image),
                Map.entry("id", id)
            )
        );
    }
}
