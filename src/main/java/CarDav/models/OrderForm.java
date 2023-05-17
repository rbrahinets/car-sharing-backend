package CarDav.models;

import org.springframework.stereotype.Component;

import java.util.Date;


public class OrderForm {
    private int id_order;

    private int id_car;

    private int id_client;

    private int rent_term;

    private double amount_pay;

    private Date date_order;

    private Date date_start_use;

    private Date date_end_use;

    public OrderForm() {
    }

    public OrderForm(int id_order, int id_car, int id_client,
                     int rent_term, double amount_pay, Date date_order,
                     Date date_start_use, Date date_end_use) {
        this.id_order = id_order;
        this.id_car = id_car;
        this.id_client = id_client;
        this.rent_term = rent_term;
        this.amount_pay = amount_pay;
        this.date_order = date_order;
        this.date_start_use = date_start_use;
        this.date_end_use = date_end_use;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getRent_term() {
        return rent_term;
    }

    public void setRent_term(int rent_term) {
        this.rent_term = rent_term;
    }

    public double getAmount_pay() {
        return amount_pay;
    }

    public void setAmount_pay(double amount_pay) {
        this.amount_pay = amount_pay;
    }

    public Date getDate_order() {
        return date_order;
    }

    public void setDate_order(Date date_order) {
        this.date_order = date_order;
    }

    public Date getDate_start_use() {
        return date_start_use;
    }

    public void setDate_start_use(Date date_start_use) {
        this.date_start_use = date_start_use;
    }

    public Date getDate_end_use() {
        return date_end_use;
    }

    public void setDate_end_use(Date date_end_use) {
        this.date_end_use = date_end_use;
    }
}
