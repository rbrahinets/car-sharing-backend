package CarDav.DAO;

import CarDav.models.Admin;
import CarDav.models.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFormDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderFormDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OrderForm> index(){
        return jdbcTemplate.query("SELECT * FROM order_form", new OrderFormMapper());
    }
}
