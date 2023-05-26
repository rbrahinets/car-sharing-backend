package com.carsharing.repositories;

import com.carsharing.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class AdminRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public AdminRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Admin> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM `admin`",
            new BeanPropertyRowMapper<>(Admin.class)
        );
    }

    public Optional<Admin> findById(long id) {
        return jdbcTemplate.query(
                "SELECT * FROM `admin` WHERE id=:id",
                Map.ofEntries(Map.entry("id", id)),
                new BeanPropertyRowMapper<>(Admin.class)
            )
            .stream().findAny();
    }

    public void save(Admin admin) {
        jdbcTemplate.update(
            "INSERT INTO `admin` (first_name, last_name, email, password)"
                + "VALUES (:first_name, :last_name, :email, :password)",
            Map.ofEntries(
                Map.entry("first_name", admin.getFirstName()),
                Map.entry("last_name", admin.getLastName()),
                Map.entry("email", admin.getEmail()),
                Map.entry("password", String.copyValueOf(admin.getPassword()))
            )
        );
    }

    public void update(long id, Admin admin) {
        jdbcTemplate.update(
            "UPDATE `admin`" +
                " SET first_name=:first_name, last_name=:last_name, email=:email, password=:password" +
                " WHERE id=:id",
            Map.ofEntries(
                Map.entry("first_name", admin.getFirstName()),
                Map.entry("last_name", admin.getLastName()),
                Map.entry("email", admin.getEmail()),
                Map.entry("password", String.copyValueOf(admin.getPassword())),
                Map.entry("id", id)
            )
        );
    }

    public void delete(long id) {
        jdbcTemplate.update(
            "DELETE FROM `admin` WHERE id=:id",
            Map.ofEntries(Map.entry("id", id))
        );
    }

    public Optional<Admin> findByEmail(String email) {
        return jdbcTemplate.query(
                "SELECT * FROM `admin` WHERE email=:email",
                Map.ofEntries(Map.entry("email", email)),
                new BeanPropertyRowMapper<>(Admin.class)
            )
            .stream().findAny();
    }
}
