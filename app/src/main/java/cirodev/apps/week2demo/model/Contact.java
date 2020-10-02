package cirodev.apps.week2demo.model;

import java.io.Serializable;

public class Contact implements Serializable  {

    private String name, date, phone, mail, description;

    public Contact(String name, String date, String phone, String mail, String description) {
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.mail = mail;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
