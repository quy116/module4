package com.example.ss4.repository;

import com.example.ss4.model.Email;

import java.util.List;

public interface IEmailRepository {
    Email showList();

    void update(Email email);
}
