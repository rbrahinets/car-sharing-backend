package com.carsharing.models;

import java.util.Arrays;
import java.util.Objects;

public class Car {
    private long id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private long idCategory;
    private String plate;
    private boolean available;
    private byte[] image;

    public Car() {
    }

    public Car(
        long id,
        String brand,
        String model,
        int year,
        double price,
        long idCategory,
        String plate,
        boolean available,
        byte[] image
    ) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.idCategory = idCategory;
        this.plate = plate;
        this.available = available;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public String getPlate() {
        return plate;
    }

    public boolean isAvailable() {
        return available;
    }

    public byte[] getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id
            && year == car.year
            && Double.compare(car.price, price) == 0
            && idCategory == car.idCategory
            && available == car.available
            && Objects.equals(brand, car.brand)
            && Objects.equals(model, car.model)
            && Objects.equals(plate, car.plate)
            && Arrays.equals(image, car.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, brand, model, year, price, idCategory, plate, available);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
            "id=" + id +
            ", brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", year=" + year +
            ", price=" + price +
            ", idCategory=" + idCategory +
            ", plate='" + plate + '\'' +
            ", available=" + available +
            '}';
    }
}
