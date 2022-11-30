package com.example.addressbook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {

    //uc1

   @GetMapping("/get")
    public String display(){
       return " Creating new Address Book";
   }
   @PostMapping("/newUser")
    public String userAdd(@RequestBody String fName,String lName , String phoneNumber , String email){
       return "userData"+ fName +" "+lName+" "+phoneNumber
               +" "+email;
   }
   @PutMapping("/update/{fName}")
    public  String update(@PathVariable String fName , @RequestBody String lName , String email , String phoneNumber ){
       return "updating user data"+ fName+" "+lName+" "+email+" "+phoneNumber;

   }
}
