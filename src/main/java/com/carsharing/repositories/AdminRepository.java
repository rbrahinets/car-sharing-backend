package com.carsharing.repositories;

import com.carsharing.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Admin> index(){
        return jdbcTemplate.query("SELECT * FROM admin", new AdminMapper());
    }

}
