package com.carsharing.DAO;

import com.carsharing.models.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client();

        client.setId_client(resultSet.getInt("id_client"));
        client.setName(resultSet.getString("name"));
        client.setSurname(resultSet.getString("surname"));
        client.setEmail(resultSet.getString("email"));
        client.setKeyword(resultSet.getString("keyword"));
        client.setPassport_id(resultSet.getString("passport_number"));
        client.setAuthorization(resultSet.getDate("authorization"));

        return client;
    }
}
