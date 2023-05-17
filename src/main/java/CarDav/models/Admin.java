package CarDav.models;

import java.util.Date;

public class Admin {
    private int id_admin;

    private String surname;

    private String name;

    private String email;

    private String keyword;

    private Date authorization;
    private String image;

    public Admin() {
    }

    public Admin(int id_admin, String surname, String name,
                 String email, String keyword,
                 Date authorization, String image) {
        this.id_admin = id_admin;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.keyword = keyword;
        this.authorization = authorization;
        this.image = image;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Date authorization) {
        this.authorization = authorization;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
