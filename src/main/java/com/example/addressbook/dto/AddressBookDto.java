package com.example.addressbook.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class AddressBookDto {
    @NotEmpty(message = "Employee cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "user name Invalid")
 public String fName;
    @NotEmpty(message = "Employee cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "users last name Invalid")
     public  String lName;
 public String email;
 public Long phoneNumber;
 public String state;
 public String city;
 public Long zipcode;

    public AddressBookDto(String fName, String lName, String email, Long phoneNumber, String state,String city,Long zipcode) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city=city;
        this.state=state;
        this.zipcode=zipcode;
    }
}
