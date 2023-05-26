package com.carsharing.DAO;

import com.carsharing.models.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin admin = new Admin();

        admin.setId_admin(resultSet.getInt("id_admin"));
        admin.setName(resultSet.getString("name"));
        admin.setSurname(resultSet.getString("surname"));
        admin.setEmail(resultSet.getString("email"));
        admin.setKeyword(resultSet.getString("keyword"));
        admin.setAuthorization(resultSet.getDate("authorization"));
        admin.setImage(resultSet.getString("image"));

        return admin;
    }
}
