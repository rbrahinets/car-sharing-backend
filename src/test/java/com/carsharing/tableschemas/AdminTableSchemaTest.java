package com.carsharing.tableschemas;

import com.carsharing.configs.DatabaseConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.jdbc.JdbcTestUtils;

import static org.assertj.core.api.Assertions.assertThatCode;

@JdbcTest
@ContextConfiguration(classes = {
    DatabaseConfig.class
})
@Sql(scripts = {
    "classpath:db/migration/admin/V20230517160644__Create_table_admin.sql"
})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdminTableSchemaTest {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private MapSqlParameterSource params;

    @BeforeEach
    void setUp() {
        params = new MapSqlParameterSource();
        params.addValue("first_name", "John");
        params.addValue("last_name", "Smith");
        params.addValue("email", "test@carsharing.com");
        params.addValue("password", "password");
        params.addValue("role", "ROLE_ADMIN");
    }

    @AfterEach
    void tearDown() {
        JdbcTestUtils.dropTables(
            jdbcTemplate.getJdbcTemplate(),
            "`admin`"
        );
    }

    @Test
    @DisplayName("Failed to insert null first name value")
    void failed_to_insert_null_first_name_value() {
        params.addValue("first_name", null);

        assertThatCode(
            () -> jdbcTemplate.update(
                "INSERT INTO `admin`(`first_name`, `last_name`, `email`, password) "
                    + "VALUES (:first_name, :last_name, :email, :password)",
                params
            )
        )
            .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    @DisplayName("Failed to insert null last name value")
    void failed_to_insert_null_last_name_value() {
        params.addValue("last_name", null);

        assertThatCode(
            () -> jdbcTemplate.update(
                "INSERT INTO `admin`(first_name, last_name, email, password) "
                    + "VALUES (:first_name, :last_name, :email, :password)",
                params
            )
        )
            .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    @DisplayName("Failed to insert null email value")
    void failed_to_insert_null_email_value() {
        params.addValue("email", null);

        assertThatCode(
            () -> jdbcTemplate.update(
                "INSERT INTO `admin`(first_name, last_name, email, password) "
                    + "VALUES (:first_name, :last_name, :email, :password)",
                params
            )
        )
            .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    @DisplayName("Failed to insert null password value")
    void failed_to_insert_null_password_value() {
        params.addValue("password", null);

        assertThatCode(
            () -> jdbcTemplate.update(
                "INSERT INTO `admin`(first_name, last_name, email, password) "
                    + "VALUES (:first_name, :last_name, :email, :password)",
                params
            )
        )
            .isInstanceOf(DataIntegrityViolationException.class);
    }
}
