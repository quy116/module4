package com.example.ss1.service;

import org.springframework.stereotype.Service;
@Service
public class MoneyService implements IMoneyService{

    @Override
    public double changeMoney(int dola) {
        double result = dola * 23000;
        return result;
    }
}
