package com.example.addressbook.services;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.repository.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

  public class AddressBookService implements AddressBookInterface {
    @Autowired
    IRepo iRepo;
    public AddressBookModel userAdd(AddressBookDto addressBookDto){
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
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
        AddressBookModel addressBookModel = new AddressBookModel((addressBookDto));
        Optional<AddressBookModel> addressBookModel1;
        addressBookModel1 = iRepo.findById(id);
        addressBookModel1.get().setfName(addressBookModel.getfName());
        addressBookModel1.get().setlName(addressBookModel.getlName());
    addressBookModel1.get().setEmail(addressBookModel.getEmail());
        addressBookModel1.get().setPhoneNumber(addressBookModel.getPhoneNumber());
        iRepo.save(addressBookModel1.get());
        return addressBookModel1.get();
    }
    public void deleteById(int id){
iRepo.deleteById(id);
    }

}
