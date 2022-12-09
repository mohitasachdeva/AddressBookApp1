package com.example.addressbook.services;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.model.AddressBookModel;

import java.util.List;

public interface AddressBookInterface {
   AddressBookModel userAdd(AddressBookDto addressBookDto);


    List<AddressBookModel> getAll();
    AddressBookModel update(AddressBookDto addressBookDto , int id);
    AddressBookModel deleteById(int id);

    AddressBookModel getById(int id);
//    List<String> findUserByCity( String city);
}
