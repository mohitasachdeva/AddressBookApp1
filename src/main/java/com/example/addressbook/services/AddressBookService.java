package com.example.addressbook.services;

import com.example.addressbook.dto.AddressBookDto;

import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.repository.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service

  public class AddressBookService implements AddressBookInterface {
    List<AddressBookModel>addressBookModels = new ArrayList();
    @Autowired
    IRepo iRepo;
    public AddressBookModel userAdd(AddressBookDto addressBookDto){
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
        addressBookModels.add(addressBookModel);
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
    public AddressBookModel update(AddressBookDto addressBookDto ,int id){
        if(iRepo.findById(id).isPresent()){
            AddressBookModel newAdd = new AddressBookModel( addressBookDto,id);
            AddressBookModel search =iRepo.save(newAdd);
            return search;
        }
        else{
            return null;
        }
    }
    public void deleteById(int id)
    {

        iRepo.deleteById(id);
    }

}
