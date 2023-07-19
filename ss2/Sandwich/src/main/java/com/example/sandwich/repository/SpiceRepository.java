package com.example.sandwich.repository;

import com.example.sandwich.model.Spice;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpiceRepository implements ISpiceRepository{

   private static List<Spice> spiceList = new ArrayList<>();
    static {
        spiceList.add(new Spice("Lettuce"));
        spiceList.add(new Spice("Tomato"));
        spiceList.add(new Spice("Mustard"));
        spiceList.add(new Spice("Sprouts"));
    }

    @Override
    public List<Spice> display() {
       return spiceList;
    }
}
