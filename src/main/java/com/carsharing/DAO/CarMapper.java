package com.carsharing.DAO;

import com.carsharing.models.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();

        car.setId_car(resultSet.getInt("id_car"));
        car.setId_admin(resultSet.getInt("id_admin"));
        car.setBrand(resultSet.getString("brand"));
        car.setModel(resultSet.getString("model"));
        car.setIssue_date(resultSet.getDate("issue_date"));
        car.setPrice(resultSet.getDouble("price"));
        car.setId_category(resultSet.getInt("id_category"));
        car.setPlate(resultSet.getString("plate"));
        car.setAveliable(resultSet.getBoolean("aveliable"));
        car.setDamage(resultSet.getBoolean("damage"));
        car.setURLImage(resultSet.getString("image"));

        return car;
    }
}
