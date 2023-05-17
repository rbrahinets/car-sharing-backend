package CarDav.models;

import java.util.Date;

public class Client {
    private int id_client;

    private String name;

    private String surname;

    private String email;

    private String keyword;

    private String passport_id;

    private Date authorization;

    public Client() {
    }

    public Client(int id_client, String name, String surname,
                  String email, String keyword,
                  String passport_id, Date authorization) {
        this.id_client = id_client;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.keyword = keyword;
        this.passport_id = passport_id;
        this.authorization = authorization;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(String passport_id) {
        this.passport_id = passport_id;
    }

    public Date getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Date authorization) {
        this.authorization = authorization;
    }
}
