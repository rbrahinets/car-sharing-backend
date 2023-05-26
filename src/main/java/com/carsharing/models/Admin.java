package com.carsharing.models;

import java.util.Arrays;
import java.util.Objects;

public class Admin {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private char[] password;

    public Admin() {
    }

    public Admin(long id) {
        this.id = id;
    }

    public Admin(
        long id,
        String firstName,
        String lastName,
        String email,
        char[] password
    ) {
        this(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
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

    public char[] getPassword() {
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
            && Arrays.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, Arrays.hashCode(password));
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
