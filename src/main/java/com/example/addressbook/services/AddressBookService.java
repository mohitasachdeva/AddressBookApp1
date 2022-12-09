package com.example.addressbook.services;
import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.repository.IRepo;
import com.example.addressbook.util.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
  public class AddressBookService implements AddressBookInterface {
    List<AddressBookModel> addressBookModels = new ArrayList();
    @Autowired
    IRepo iRepo;
    @Autowired
    Token token1;

    public AddressBookModel userAdd(AddressBookDto addressBookDto) {
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
        addressBookModels.add(addressBookModel);
        return iRepo.save(addressBookModel);
    }

    public List<AddressBookModel> getAll() {
        List<AddressBookModel> addressBookModels = iRepo.findAll();
        return addressBookModels;
    }

    public AddressBookModel getById(int id) {
        Optional<AddressBookModel> addressBookModel = iRepo.findById(id);
        if (addressBookModel.isPresent()) {
            return addressBookModel.get();
        } else {
            throw new AddressBookException("id is not present");
        }
    }

    public AddressBookModel update(AddressBookDto addressBookDto, int id) {
        if (iRepo.findById(id).isPresent()) {
            AddressBookModel newAdd = new AddressBookModel(addressBookDto, id);
            AddressBookModel search = iRepo.save(newAdd);
            return search;
        } else {
            throw new AddressBookException("id not found");
        }
    }

    public AddressBookModel deleteById(int id) {

        iRepo.deleteById(id);
        log.info("user data deleted");
        return null;
    }

    public List<String> findByCity(String city) {
        return iRepo.findByCity(city);
    }

    public AddressBookModel getByToken(String token) {
        int userId = token1.decodeToken(token);
        Optional<AddressBookModel> addressBookModel = iRepo.findById(userId);
        if (addressBookModel.isPresent()) {
            return iRepo.findById(Integer.valueOf(userId)).get();
        } else {
            throw new AddressBookException("Token does not match");
        }
    }

    @Override
    public AddressBookModel updateByToken( int id,String token,AddressBookDto addressBookDto) {

//        AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
//        addressBookModel=this.getByToken(token);
//        if(addressBookModel.equals(addressBookModel)){
//            AddressBookModel save = iRepo.save(addressBookModel);
//            return save;
//        }
//        else {
//            throw new AddressBookException("token not matched");
//        }
        int userId =token1.decodeToken(token);
        Optional<AddressBookModel>addressBookModel=iRepo.findById(userId)  ;
        if(addressBookModel.isPresent())
        {
           AddressBookModel addressBookModel1 = new AddressBookModel(addressBookDto);
           addressBookModel1.setId(id);
           AddressBookModel addressBookModel2=iRepo.save(addressBookModel1);
           return addressBookModel2;

        }
        else {
            throw new AddressBookException("token never matched");
        }
    }
    }





