package CarDav.Controllers;

import CarDav.DAO.AdminDAO;
import CarDav.DAO.CarDAO;
import CarDav.DAO.ClientDAO;
import CarDav.DAO.OrderFormDAO;
import CarDav.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class AdminController {
    private AdminDAO adminDAO;
    private ClientDAO clientDAO;
    private CarDAO carDAO;

    private OrderFormDAO orderFormDAO;
    @Autowired
    public AdminController(AdminDAO adminDAO, ClientDAO clientDAO,
                           CarDAO carDAO, OrderFormDAO orderFormDAO) {
        this.adminDAO = adminDAO;
        this.clientDAO = clientDAO;
        this.carDAO = carDAO;
        this.orderFormDAO = orderFormDAO;
    }

    @GetMapping("/clients")
    public String showAllClients(Model model) throws SQLException {
        model.addAttribute("clients", clientDAO.index());
        return "client/index";
    }

    @GetMapping("/cars")
    public String showAllCars(Model model) throws SQLException {
        model.addAttribute("cars", carDAO.index());
        return "car/index";
    }

    @GetMapping("/cars/new")
    public String addNewCar(Model model){
        model.addAttribute("NewCar", new Car());
        return "car/new";
    }

    @PostMapping("/cars")
    public String saveToDB(@ModelAttribute("NewCar") Car car){
        carDAO.addCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/orders")
    public String showAllOrders(Model model){
        model.addAttribute("orders", orderFormDAO.index());
        return "order/index";
    }

    @GetMapping("/cars/{id}/edit")
    public String editCar(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("car", carDAO.show(id));
        return "car/edit";
    }

    @PatchMapping("/cars/{id}")
    public String updateBook(@PathVariable("id") int id, @ModelAttribute("car") Car car){
        carDAO.updateCar(id, car);
        return "redirect:/cars";
    }

    @DeleteMapping("/cars/{id}")
    public String deleteBook(@PathVariable("id") int id){
        carDAO.deleteCar(id);
        return "redirect:/cars";
    }

}
