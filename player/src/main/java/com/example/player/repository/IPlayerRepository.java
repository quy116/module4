package com.example.player.repository;

import com.example.player.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPlayerRepository extends JpaRepository<PlayerSoccer, Integer> {
//    Page<PlayerSoccer> f
}
