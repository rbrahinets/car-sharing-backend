package CarDav.db;

import CarDav.config.DatabaseConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DatabaseTemplate {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(
                    DatabaseConfig.class
            );

    private static final NamedParameterJdbcTemplate jdbcTemplate =
            (NamedParameterJdbcTemplate) context.getBean("namedParameterJdbcTemplate");

    public static NamedParameterJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
