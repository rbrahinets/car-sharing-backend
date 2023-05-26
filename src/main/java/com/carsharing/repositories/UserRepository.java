package com.carsharing.repositories;

import com.carsharing.DAO.UserMapper;
import com.carsharing.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<User> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM `user`",
                new UserMapper()
        );
    }

    public Optional<User> findById(Long id) {
        return Optional.of(new User());
    }

    public User save(User user) {
        return user;
    }

    public User update(Long id, User user) {
        return user;
    }

    public void deleteById(Long id) {

    }
}
