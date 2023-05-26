package com.carsharing.models;

import java.util.Date;
import java.util.Objects;

public class Order {
    private int id;

    private int idCar;

    private String email;

    private double amountPrice;

    private Date rentalDate;

    private Date returnDate;

    private int idStatus;

    public Order() {
    }

    public Order(
        int id,
        int idCar,
        String email,
        double amountPrice,
        Date rentalDate,
        Date returnDate,
        int idStatus
    ) {
        this.id = id;
        this.idCar = idCar;
        this.email = email;
        this.amountPrice = amountPrice;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.idStatus = idStatus;
    }

    public int getId() {
        return id;
    }

    public int getIdCar() {
        return idCar;
    }

    public String getEmail() {
        return email;
    }

    public double getAmountPrice() {
        return amountPrice;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public int getIdStatus() {
        return idStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id
            && idCar == order.idCar
            && Double.compare(order.amountPrice, amountPrice) == 0
            && idStatus == order.idStatus
            && Objects.equals(email, order.email)
            && Objects.equals(rentalDate, order.rentalDate)
            && Objects.equals(returnDate, order.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCar, email, amountPrice, rentalDate, returnDate, idStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", idCar=" + idCar +
            ", email='" + email + '\'' +
            ", amountPrice=" + amountPrice +
            ", rentalDate=" + rentalDate +
            ", returnDate=" + returnDate +
            ", idStatus=" + idStatus +
            '}';
    }
}
