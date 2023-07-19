package com.example.bai2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class TranslateService implements ITranslateService {
    private static Map<String, String> map = new HashMap<>();
    static {
        map.put("hello", "xin chao");
        map.put("you", "ban");
        map.put("class", "lop");
        map.put("map", "ban do");
    }

    @Override
    public String translate(String findKey) {
        String result = null;
        Set set = map.keySet();
        for ( Object key: set) {
            if (findKey.equals(key)){
                result = map.get(key);
                break;
            }else {
                result = "k co nhe!!";
            }
        }
        return result;
    }
}
