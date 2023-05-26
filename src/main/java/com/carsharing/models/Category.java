package com.carsharing.models;

import java.util.Objects;

public class Category {
    private int id;
    private String name;

    public Category() {
    }

    public Category(
        int id,
        String name
    ) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category admin = (Category) o;
        return id == admin.id
            && Objects.equals(name, admin.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
