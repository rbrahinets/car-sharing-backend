package CarDav.Controllers;

import CarDav.DAO.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/car")
public class CarController {

    private CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String index(Model model) throws SQLException {
        model.addAttribute("cars", carDAO.index());
        return "car/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("car", carDAO.show(id));
        return "car/show";
    }

}
