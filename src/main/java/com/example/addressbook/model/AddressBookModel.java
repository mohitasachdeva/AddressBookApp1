package com.example.addressbook.model;

import com.example.addressbook.dto.AddressBookDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AddressBookModel {
    @Id
    @GeneratedValue
    public int id;

    private String fName;
    private String lName;
    private String email;
    private long phoneNumber;

    public AddressBookModel(AddressBookDto addressBookDto) {//saving

        this.fName = addressBookDto.fName;
        this.lName = addressBookDto.lName;
        this.email = addressBookDto.email;
        this.phoneNumber = addressBookDto.phoneNumber;
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

    public AddressBookModel(AddressBookDto addressBookDto , int id) {//updating
        this.id=id;
        this.fName = addressBookDto.fName;
        this.lName = addressBookDto.lName;
        this.email = addressBookDto.email;
        this.phoneNumber = addressBookDto.phoneNumber;
    }
}
