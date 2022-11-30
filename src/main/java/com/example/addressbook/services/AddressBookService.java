package com.example.addressbook.services;

import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.repository.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AddressBookService {
    @Autowired
    IRepo iRepo;
    public AddressBookModel userAdd(AddressBookModel addressBookModel){
        return iRepo.save(addressBookModel);
    }
    public List<AddressBookModel> getAll(){
       List<AddressBookModel>addressBookModels =iRepo.findAll();
       return addressBookModels;
    }
    public AddressBookModel getById(int id){
        AddressBookModel addressBookModel=iRepo.findById(id).get();
        return  addressBookModel;
    }
    public AddressBookModel update( AddressBookModel addressBookModel ,int id){
        addressBookModel =iRepo.findById(id).get();
        addressBookModel.setfName(addressBookModel.getfName());
        addressBookModel.setlName(addressBookModel.getlName());
        addressBookModel.setEmail(addressBookModel.getEmail());
        addressBookModel.setPhoneNumber(addressBookModel.getPhoneNumber());
        return iRepo.save(addressBookModel);
    }
    public void deleteByid(int id){
iRepo.deleteById(id);
    }

}
