package com.example.ss4.service;

import com.example.ss4.model.Email;
import com.example.ss4.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public Email showListService() {
        Email email = emailRepository.showList();
        return email;
    }

    @Override
    public void edit(Email email) {
        emailRepository.update(email);
    }

}
