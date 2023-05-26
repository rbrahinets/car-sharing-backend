package com.carsharing.models;

import java.util.Date;
import java.util.Objects;

public class Order {
    private long id;

    private long idCar;

    private String email;

    private double amountPrice;

    private Date rentalDate;

    private Date returnDate;

    private long idStatus;

    public Order() {
    }

    public Order(
        long id,
        long idCar,
        String email,
        double amountPrice,
        Date rentalDate,
        Date returnDate,
        long idStatus
    ) {
        this.id = id;
        this.idCar = idCar;
        this.email = email;
        this.amountPrice = amountPrice;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.idStatus = idStatus;
    }

    public long getId() {
        return id;
    }

    public long getIdCar() {
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

    public long getIdStatus() {
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
