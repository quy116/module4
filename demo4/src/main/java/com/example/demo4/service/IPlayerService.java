package com.example.demo4.service;

import com.example.demo4.model.PlayerSoccer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPlayerService {
    List<PlayerSoccer> showListService();

    void delete(int id);

    List<PlayerSoccer> findById(int id);

    void add(PlayerSoccer playerSoccer);

    PlayerSoccer edit(int id);

    void editTwo(PlayerSoccer playerSoccer);
}
