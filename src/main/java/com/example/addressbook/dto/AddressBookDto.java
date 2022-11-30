package com.example.addressbook.dto;

public class AddressBookDto {
 public String fName;
 public  String lName;
 public String email;
 public Long phoneNumber;

    public AddressBookDto(String fName, String lName, String email, Long phoneNumber) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
