package com.carsharing.DAO;

import com.carsharing.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class ClientDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> index() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM Client", new ClientMapper());
    }

    public Client show(int id) throws SQLException{
        return jdbcTemplate.query("SELECT * FROM client WHERE id_client=?", new Object[]{id},
                new ClientMapper()).stream().findAny().orElse(null);
    }
}
