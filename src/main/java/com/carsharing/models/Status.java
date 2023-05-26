package com.carsharing.models;

import java.util.Objects;

public class Status {
    private long id;
    private String name;

    public Status() {
    }

    public Status(long id) {
        this.id = id;
    }

    public Status(
        long id,
        String name
    ) {
        this(id);
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return id == status.id
            && Objects.equals(name, status.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Status{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
