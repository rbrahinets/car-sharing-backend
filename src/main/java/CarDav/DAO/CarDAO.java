package CarDav.DAO;

import CarDav.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class CarDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> index() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM Car", new CarMapper());
    }

    public Car show(int id) throws SQLException{
        return jdbcTemplate.query("SELECT * FROM car WHERE id_car=?", new Object[]{id},
                new CarMapper()).stream().findAny().orElse(null);
    }

    public void addCar(Car car){
        jdbcTemplate.update("INSERT INTO car(Id_admin, brand, Model, Issue_date, price, id_category, Plate, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                car.getId_admin(), car.getBrand(), car.getModel(),
                car.getIssue_date(), car.getPrice(), car.getId_category(),
                car.getPlate(), car.getURLImage());
    }

    public void updateCar(int id, Car car){
        jdbcTemplate.update("UPDATE car SET Id_admin = ?, brand = ?, " +
                        "Model = ?, Issue_date = ?, price = ?, id_category =? , Plate = ?, " +
                        "Aveliable = ?, Damage = ?, image = ? WHERE id_car = ?",
                car.getId_admin(), car.getBrand(), car.getModel(),
                car.getIssue_date(), car.getPrice(), car.getId_category(),
                car.getPlate(), car.isAveliable(), car.isDamage(),
                car.getURLImage(), id);
    }

    public void deleteCar(int id){
        jdbcTemplate.update("DELETE FROM car WHERE id_car = ?", id);
    }

}
