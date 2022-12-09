package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.dto.ResponseDto;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.services.AddressBookInterface;

import com.example.addressbook.util.Token;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class AddressBookController {
    @Autowired
    AddressBookInterface addressBookInterface;
    @Autowired
    Token token;




    @PostMapping("/newUser")
    public ResponseEntity<ResponseDto> userAdd( @Valid @RequestBody AddressBookDto addressBookDto)  {

        AddressBookModel addressBookModel = addressBookInterface.userAdd(addressBookDto);
        String idToken= token.createToken(addressBookModel.id);
        ResponseDto responseDto = new ResponseDto("New user Added", addressBookModel,idToken);

        ResponseEntity<ResponseDto> response = new ResponseEntity(responseDto, HttpStatus.OK);
        log.info(String.valueOf(idToken));
        return response;

    }
    @GetMapping("/all")
    public ResponseEntity<ResponseDto> greetingModelsFindAll() throws AddressBookException {
        List<AddressBookModel> addressBookModel = addressBookInterface.getAll();
        ResponseDto responseDto = new ResponseDto("getting all users ",addressBookModel,token.toString());
        ResponseEntity<ResponseDto>response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }
    @GetMapping("/getting/{id}")
    public ResponseEntity<ResponseDto> getting( @PathVariable int id){
        AddressBookModel addressBookModel = addressBookInterface.getById(id);
        ResponseDto responseDto = new ResponseDto("get by id ", addressBookModel,token.toString());
        ResponseEntity<ResponseDto>response=new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updating( @Valid @PathVariable int id , @RequestBody AddressBookDto addressBookDto)throws AddressBookException{
        AddressBookModel addressBookModel = addressBookInterface.update(addressBookDto,id);
        ResponseDto responseDto = new ResponseDto("updating user", addressBookModel, token.toString());
        ResponseEntity<ResponseDto>response=new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }

   @DeleteMapping("/del/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable int id){
       AddressBookModel addressBookModel = addressBookInterface.deleteById(id);
       ResponseDto responseDto = new ResponseDto("get by id and delete user ", addressBookModel,toString());
       ResponseEntity<ResponseDto>response=new ResponseEntity<>(responseDto,HttpStatus.OK);
       return response;
   }

//    @GetMapping("/getCity/{city}")
//    public ResponseEntity<ResponseDto> findUserByCity(@PathVariable("city") String city){
//        List<String> addressBookList1= null;
//        addressBookList1 = (List<String>) addressBookInterface.findUserByCity(city);
//        ResponseDto responseDto = new ResponseDto("Employee of Specific Department!!!",addressBookList1);
//        ResponseEntity<ResponseDto> response = new ResponseEntity(responseDto, HttpStatus.OK);
//        return response;
//    }
}
