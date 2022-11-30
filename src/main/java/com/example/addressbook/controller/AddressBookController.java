package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.services.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;

    //uc2


    @PostMapping("/newUser")
    public AddressBookModel userAdd(@RequestBody AddressBookDto addressBookDto) {
        return addressBookService.userAdd(addressBookDto);

    }
    @GetMapping("/all")
    public List<AddressBookModel> greetingModelsFindAll() {
        return addressBookService.getAll();
    }
    @GetMapping("/getting/{id}")
    public AddressBookModel getting( @PathVariable int id){
        return addressBookService.getById(id);
    }
    @PutMapping("/update/{id}")
    public  AddressBookModel updating(@PathVariable int id , @RequestBody AddressBookDto addressBookDto){
       return addressBookService.update(addressBookDto,id);
    }
   @DeleteMapping("/del/{id}")
    public void delete(@PathVariable int id){
        addressBookService.deleteByid(id);
   }
}
