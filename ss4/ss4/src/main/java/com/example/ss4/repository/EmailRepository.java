package com.example.ss4.repository;

import com.example.ss4.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static Email email = new Email(1, "Vietnamese", 15, true, "ki ten quy");

    //    static {
//       Email email1 =new Email(1,"English",15,true,"ki ten quy");
//    }
    @Override
    public Email showList() {
        return email;
    }

    @Override
    public void update(Email email) {
        email.setSize(email.getSize());
        email.setLanguages(email.getLanguages());
        email.setSpamsFilter(email.isSpamsFilter());
        email.setSignature(email.getSignature());
    }
}
