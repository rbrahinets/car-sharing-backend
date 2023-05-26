package com.carsharing.models;

import java.util.Objects;

public class Admin {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Admin() {
    }

    public Admin(
        int id,
        String firstName,
        String lastName,
        String email,
        String password
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id
            && Objects.equals(firstName, admin.firstName)
            && Objects.equals(lastName, admin.lastName)
            && Objects.equals(email, admin.email)
            && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
