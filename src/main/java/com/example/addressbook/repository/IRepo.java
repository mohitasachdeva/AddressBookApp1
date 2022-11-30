package com.example.addressbook.repository;

import com.example.addressbook.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IRepo extends JpaRepository <AddressBookModel,Integer> {
}
