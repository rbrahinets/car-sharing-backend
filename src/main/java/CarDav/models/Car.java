package CarDav.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class Car {
    private int id_car;

    private int id_admin;

    @NotEmpty(message = "Brand shouldn\'d be empty")
    private String brand;

    @NotEmpty(message = "Model shouldn\'d be empty")
    private String model;

   // @Min(value = 1970, message = "Issue date must be greater then 1970")
    private Date issue_date;

    @Min(value = 0, message = "Price must be greater then 0")
    private double price;

    private int id_category;

 //   @Pattern(regexp = "^[A-Z]{2} \\d{4} [A-Z]{2}$", message = "Incorrect plate format")
    private String plate;

    private boolean aveliable;

    private boolean damage;

    private String URLImage;

    public Car() {
    }

    public Car(int id_car, int id_admin, String brand,
               String model, Date issue_date, double price,
               int id_category, String plate, boolean aveliable,
               boolean damage, String URLImage) {
        this.id_car = id_car;
        this.id_admin = id_admin;
        this.brand = brand;
        this.model = model;
        this.issue_date = issue_date;
        this.price = price;
        this.id_category = id_category;
        this.plate = plate;
        this.aveliable = aveliable;
        this.damage = damage;
        this.URLImage = URLImage;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isAveliable() {
        return aveliable;
    }

    public void setAveliable(boolean aveliable) {
        this.aveliable = aveliable;
    }

    public boolean isDamage() {
        return damage;
    }

    public void setDamage(boolean damage) {
        this.damage = damage;
    }

    public String getURLImage() {
        return URLImage;
    }

    public void setURLImage(String URLImage) {
        this.URLImage = URLImage;
    }
}
