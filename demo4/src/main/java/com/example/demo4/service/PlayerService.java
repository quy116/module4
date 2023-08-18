package com.example.demo4.service;

import com.example.demo4.model.PlayerSoccer;
import com.example.demo4.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository repository;

    @Override
    public List<PlayerSoccer> showListService() {
        return repository.showList();
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<PlayerSoccer> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void add(PlayerSoccer playerSoccer) {
        repository.add(playerSoccer);
    }

    @Override
    public PlayerSoccer edit(int id) {
        PlayerSoccer playerSoccer = repository.finByIdEdit(id);
        return playerSoccer;
    }

    @Override
    public void editTwo(PlayerSoccer playerSoccer,int id) {
        repository.edit(playerSoccer);
    }
}
