package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.dto.ResponseDto;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.model.Email;
import com.example.addressbook.services.AddressBookInterface;
import com.example.addressbook.services.EmailServiceInterface;
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
    @Autowired
    EmailServiceInterface emailServiceInterface;




    @PostMapping("/newUser")
    public ResponseEntity<ResponseDto> userAdd( @Valid @RequestBody AddressBookDto addressBookDto)  {

        AddressBookModel addressBookModel = addressBookInterface.userAdd(addressBookDto);
        String idToken= token.createToken(addressBookModel.id);
        Email email1=new Email(addressBookModel.getEmail(),"user is registered",addressBookModel.getFName());
       emailServiceInterface.sendMail(email1);
        ResponseDto responseDto = new ResponseDto("New user Added", addressBookModel,idToken);
        ResponseEntity<ResponseDto> response = new ResponseEntity(responseDto, HttpStatus.OK);

        return response;

    }
    @GetMapping("/all")
    public ResponseEntity<ResponseDto> greetingModelsFindAll() throws AddressBookException {
        List<AddressBookModel> addressBookModel = addressBookInterface.getAll();
        ResponseDto responseDto = new ResponseDto("getting all users ",addressBookModel,null);
        ResponseEntity<ResponseDto>response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }
    @GetMapping("/getting/{id}")
    public ResponseEntity<ResponseDto> getting( @PathVariable int id){
        AddressBookModel addressBookModel = addressBookInterface.getById(id);
        ResponseDto responseDto = new ResponseDto("get by id ", addressBookModel,null);
        ResponseEntity<ResponseDto>response=new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updating( @Valid @PathVariable int id , @RequestBody AddressBookDto addressBookDto)throws AddressBookException{
        AddressBookModel addressBookModel = addressBookInterface.update(addressBookDto,id);

        ResponseDto responseDto = new ResponseDto("updating user", addressBookModel, null);
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

    @GetMapping("/getByCity/{city}")
    public ResponseEntity<ResponseDto> findByCity(@PathVariable("city") String city){
        List<String> list1= null;
        list1 = addressBookInterface.findByCity(city);
        ResponseDto responseDto = new ResponseDto("Employee of Specific City!!!",list1,toString());
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }
    @GetMapping("/get/{token}")
    public ResponseEntity<ResponseDto>getByToken(@PathVariable String token){
        AddressBookModel addressBookModel=addressBookInterface.getByToken(token);
        ResponseDto responseDto =new ResponseDto("get by token",addressBookModel,token);
        ResponseEntity<ResponseDto>response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }
    @PutMapping("/updateToken/{id}")
    public ResponseEntity<ResponseDto> updating(@PathVariable int id, @RequestParam String token, @RequestBody AddressBookDto addressBookDto)throws AddressBookException{
        AddressBookModel addressBookModel = addressBookInterface.updateByToken( id, token,addressBookDto);
        ResponseDto responseDto = new ResponseDto("updated user", addressBookModel, token);
        ResponseEntity<ResponseDto>response=new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/delByToken/{token}")
    public ResponseEntity<ResponseDto> delete(@PathVariable String token){
        AddressBookModel addressBookModel = addressBookInterface.deleteByToken(token);
        ResponseDto responseDto = new ResponseDto("get by token and delete user ", addressBookModel,token);
        ResponseEntity<ResponseDto>response=new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }

}
