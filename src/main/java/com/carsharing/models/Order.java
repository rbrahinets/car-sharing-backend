package com.carsharing.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private long id;

    private long idCar;

    private String email;

    private double amountPrice;

    private LocalDateTime rentalDate;

    private LocalDateTime returnDate;

    private long idStatus;

    public Order() {
    }

    public Order(long id) {
        this.id = id;
    }

    public Order(
        long id,
        long idCar,
        String email,
        double amountPrice,
        LocalDateTime rentalDate,
        LocalDateTime returnDate,
        long idStatus
    ) {
        this(id);
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

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAmountPrice() {
        return amountPrice;
    }

    public void setAmountPrice(double amountPrice) {
        this.amountPrice = amountPrice;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
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
