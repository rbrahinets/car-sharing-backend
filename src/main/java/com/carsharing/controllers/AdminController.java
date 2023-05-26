package com.carsharing.controllers;

import com.carsharing.repositories.AdminRepository;
import com.carsharing.repositories.CarRepository;
import com.carsharing.repositories.ClientRepository;
import com.carsharing.repositories.OrderFormRepository;
import com.carsharing.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class AdminController {
    private AdminRepository adminRepository;
    private ClientRepository clientRepository;
    private CarRepository carRepository;

    private OrderFormRepository orderFormRepository;
    @Autowired
    public AdminController(AdminRepository adminRepository, ClientRepository clientRepository,
                           CarRepository carRepository, OrderFormRepository orderFormRepository) {
        this.adminRepository = adminRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
        this.orderFormRepository = orderFormRepository;
    }

    @GetMapping("/clients")
    public String showAllClients(Model model) throws SQLException {
        model.addAttribute("clients", clientRepository.index());
        return "client/index";
    }

    @GetMapping("/cars")
    public String showAllCars(Model model) throws SQLException {
        model.addAttribute("cars", carRepository.index());
        return "car/index";
    }

    @GetMapping("/cars/new")
    public String addNewCar(Model model){
        model.addAttribute("NewCar", new Car());
        return "car/new";
    }

    @PostMapping("/cars")
    public String saveToDB(@ModelAttribute("NewCar") Car car){
        carRepository.addCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/orders")
    public String showAllOrders(Model model){
        model.addAttribute("orders", orderFormRepository.index());
        return "order/index";
    }

    @GetMapping("/cars/{id}/edit")
    public String editCar(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("car", carRepository.show(id));
        return "car/edit";
    }

    @PatchMapping("/cars/{id}")
    public String updateBook(@PathVariable("id") int id, @ModelAttribute("car") Car car){
        carRepository.updateCar(id, car);
        return "redirect:/cars";
    }

    @DeleteMapping("/cars/{id}")
    public String deleteBook(@PathVariable("id") int id){
        carRepository.deleteCar(id);
        return "redirect:/cars";
    }

}
