package com.example.sandwich.service;

import com.example.sandwich.model.Spice;
import com.example.sandwich.repository.ISpiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpiceService implements ISpiceService {
    @Autowired
    private ISpiceRepository repository;

    @Override
    public List<Spice> showList() {
        return  repository.display();
    }
}
