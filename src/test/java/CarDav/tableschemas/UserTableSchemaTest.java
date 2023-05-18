package CarDav.tableschemas;

import CarDav.config.DatabaseConfig;
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
        "classpath:db/migration/role/V20230517160344__Create_table_role.sql",
        "classpath:db/migration/user/V20230517160644__Create_table_user.sql",
        "classpath:db/migration/clientcategory/V20230517160844__Create_table_client_category.sql",
        "classpath:db/migration/order/V20230517160944__Create_table_order.sql"
})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserTableSchemaTest {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private MapSqlParameterSource params;

    @BeforeEach
    void setUp() {
        params = new MapSqlParameterSource();
        params.addValue("first_name", "John");
        params.addValue("last_name", "Smith");
        params.addValue("email", "test@email.com");
        params.addValue("id_role", 1);
    }

    @AfterEach
    void tearDown() {
        JdbcTestUtils.dropTables(
                jdbcTemplate.getJdbcTemplate(),
                "`role`, `client_category`, `order`, `user`"
        );
    }

    @Test
    @DisplayName("Failed to insert null first name value")
    void failed_to_insert_null_first_name_value() {
        params.addValue("first_name", null);

        assertThatCode(
                () -> jdbcTemplate.update(
                        "INSERT INTO `user`(`first_name`, `last_name`, `email`, `id_role`) "
                                + "VALUES (:first_name, :last_name, :email, :id_role)",
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
                        "INSERT INTO `user`(first_name, last_name, email, id_role) "
                                + "VALUES (:first_name, :last_name, :email, :id_role)",
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
                        "INSERT INTO `user`(first_name, last_name, email, id_role) "
                                + "VALUES (:first_name, :last_name, :email, :id_role)",
                        params
                )
        )
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    @DisplayName("Failed to insert null id of role value")
    void failed_to_insert_null_id_of_role_value() {
        params.addValue("id_role", null);

        assertThatCode(
                () -> jdbcTemplate.update(
                        "INSERT INTO `user`(first_name, last_name, email, id_role) "
                                + "VALUES (:first_name, :last_name, :email, :id_role)",
                        params
                )
        )
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}
