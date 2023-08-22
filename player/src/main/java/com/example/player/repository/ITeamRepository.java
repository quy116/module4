package com.example.player.repository;

import com.example.player.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITeamRepository extends JpaRepository<Team,Integer> {
    @Query(value = "select * from team",nativeQuery = true)
    List<Team> findAll();
    @Query(value = "insert into team values(team)",nativeQuery = true)
    void add(Team team);
}
