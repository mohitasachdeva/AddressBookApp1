package com.example.addressbook.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class AddressBookModel {
    @Id
    @GeneratedValue
    public int id;

    private String fName;
    private String lName;
    private String email;
    private long phoneNumber;

    public AddressBookModel(String fName, String lName, String email, long phoneNumber,int id) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }



    public AddressBookModel() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
