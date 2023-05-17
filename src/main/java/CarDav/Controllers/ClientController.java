package CarDav.Controllers;

import CarDav.DAO.CarDAO;
import CarDav.DAO.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/client")
public class ClientController {

    private CarDAO carDAO;

    @Autowired
    public ClientController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/cars")
    public String showAllCars(Model model) throws SQLException {
        model.addAttribute("cars", carDAO.index());
        return "car/index";
    }

    @GetMapping("/cars/{id}")
    public String show(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("car", carDAO.show(id));
        return "car/show";
    }
}
