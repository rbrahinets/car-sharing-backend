package CarDav.util;

import CarDav.DAO.CarDAO;
import CarDav.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CarValidator implements Validator {
    private CarDAO carDAO;

    @Autowired
    public CarValidator(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Car.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Car car = (Car) o;

//        if(carDAO.show(person.getEmail()).isPresent())
//            errors.rejectValue("email", "", "This email is already taken");
    }
}
