package com.carsharing.repositories;

import com.carsharing.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class StatusRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public StatusRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Status> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM `status`",
            new BeanPropertyRowMapper<>(Status.class)
        );
    }

    public Optional<Status> findById(long id) {
        return jdbcTemplate.query(
                "SELECT * FROM `status` WHERE id=:id",
                Map.ofEntries(Map.entry("id", id)),
                new BeanPropertyRowMapper<>(Status.class)
            )
            .stream().findAny();
    }

    public void save(Status status) {
        jdbcTemplate.update(
            "INSERT INTO `status` (name) VALUES (:name)",
            Map.ofEntries(Map.entry("name", status.getName()))
        );
    }

    public void update(long id, Status status) {
        jdbcTemplate.update(
            "UPDATE `status` SET name=:name WHERE id=:id",
            Map.ofEntries(
                Map.entry("name", status.getName()),
                Map.entry("id", id)
            )
        );
    }

    public void delete(long id) {
        jdbcTemplate.update(
            "DELETE FROM `status` WHERE id=:id",
            Map.ofEntries(Map.entry("id", id))
        );
    }

    public Optional<Status> findByName(String name) {
        return jdbcTemplate.query(
                "SELECT * FROM `status` WHERE name=:name",
                Map.ofEntries(Map.entry("name", name)),
                new BeanPropertyRowMapper<>(Status.class)
            )
            .stream().findAny();
    }
}
