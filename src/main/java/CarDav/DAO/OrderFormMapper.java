package CarDav.DAO;

import CarDav.models.OrderForm;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderFormMapper implements RowMapper<OrderForm> {
    @Override
    public OrderForm mapRow(ResultSet resultSet, int i) throws SQLException {
        OrderForm orderForm = new OrderForm();

        orderForm.setId_order(resultSet.getInt("id_order"));
        orderForm.setId_car(resultSet.getInt("id_car"));
        orderForm.setId_client(resultSet.getInt("id_client"));
        orderForm.setRent_term(resultSet.getInt("rent_term"));
        orderForm.setAmount_pay(resultSet.getDouble("amount_pay"));
        orderForm.setDate_order(resultSet.getDate("date_order"));
        orderForm.setDate_start_use(resultSet.getDate("date_start_use"));
        orderForm.setDate_end_use(resultSet.getDate("date_end_use"));

        return orderForm;
    }
}
