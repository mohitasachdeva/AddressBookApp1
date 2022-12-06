package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.dto.ResponseDto;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.services.AddressBookInterface;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressBookController {
    @Autowired
    AddressBookInterface addressBookInterface;




    @PostMapping("/newUser")
    public ResponseEntity<ResponseDto> userAdd( @Valid @RequestBody AddressBookDto addressBookDto)  {
        AddressBookModel addressBookModel = addressBookInterface.userAdd(addressBookDto);
        ResponseDto responseDto = new ResponseDto("New user Added", addressBookModel);
        ResponseEntity<ResponseDto> response = new ResponseEntity(responseDto, HttpStatus.OK);
        return response;

    }
    @GetMapping("/all")
    public List<AddressBookModel> greetingModelsFindAll() throws AddressBookException {
        return addressBookInterface.getAll();
    }
    @GetMapping("/getting/{id}")
    public AddressBookModel getting( @PathVariable int id){
        return addressBookInterface.getById(id);
    }
    @PutMapping("/update/{id}")
    public  AddressBookModel updating(@PathVariable int id , @RequestBody AddressBookDto addressBookDto)throws AddressBookException{
       return addressBookInterface.update(addressBookDto,id);
    }
   @DeleteMapping("/del/{id}")
    public void delete(@PathVariable int id){
        addressBookInterface.deleteById(id);
   }
}
