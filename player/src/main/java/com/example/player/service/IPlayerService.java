package com.example.player.service;
import com.example.player.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPlayerService {
    Page<PlayerSoccer> showListService(Pageable pageable);

    void delete(int id);

    Optional<PlayerSoccer> findById(int id);

    void add(PlayerSoccer playerSoccer);

    PlayerSoccer edit(int id);

    void editTwo(PlayerSoccer playerSoccer,int id);
}
