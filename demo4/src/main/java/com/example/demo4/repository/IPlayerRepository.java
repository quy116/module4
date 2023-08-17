package com.example.demo4.repository;

import com.example.demo4.model.PlayerSoccer;

import java.util.List;

public interface IPlayerRepository {

    List<PlayerSoccer> showList();

    void delete(int id);

    List<PlayerSoccer> findById(int id);

    void add(PlayerSoccer playerSoccer);

    PlayerSoccer finByIdEdit(int id);

    void edit(PlayerSoccer playerSoccer);
}
