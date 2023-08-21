package com.example.player.service;
import com.example.player.model.PlayerSoccer;
import com.example.player.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository repository;

    @Override
    public Page<PlayerSoccer> showListService(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public PlayerSoccer findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void add(PlayerSoccer playerSoccer) {
        repository.save(playerSoccer);
    }

    @Override
    public PlayerSoccer edit(int id) {
        PlayerSoccer playerSoccer = repository.findById(id).get();
        return playerSoccer;
    }

    @Override
    public void editTwo(PlayerSoccer playerSoccer, int id) {
        repository.save(playerSoccer);
    }
}
