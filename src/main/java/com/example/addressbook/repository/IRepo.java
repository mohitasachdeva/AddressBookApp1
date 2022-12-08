package com.example.addressbook.repository;

import com.example.addressbook.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IRepo extends JpaRepository <AddressBookModel,Integer>
{
//    @Query(value = "select * from address_book_model where city = :city ",nativeQuery = true)
//    List<String> findUserByCity(String department);

}

