package com.example.addressbook.model;

import com.example.addressbook.dto.AddressBookDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public  class AddressBookModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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



    public AddressBookModel(AddressBookDto addressBookDto , int id) {//updating
        this.id=id;
        this.fName = addressBookDto.fName;
        this.lName = addressBookDto.lName;
        this.email = addressBookDto.email;
        this.phoneNumber = addressBookDto.phoneNumber;
    }
}
