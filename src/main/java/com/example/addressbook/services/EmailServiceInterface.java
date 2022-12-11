package com.example.addressbook.services;

import com.example.addressbook.dto.ResponseDto;
import com.example.addressbook.model.Email;
import org.springframework.http.ResponseEntity;

public interface EmailServiceInterface {
    ResponseEntity<ResponseDto> sendMail(Email email);


}
