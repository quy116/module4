package com.example.player.service;

import com.example.player.model.Team;
import com.example.player.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService{
    @Autowired
    ITeamRepository iTeamRepository;

    @Override
    public List<Team> ShowTeam() {

        return  iTeamRepository.findAll();
    }

    @Override
    public void add(Team team) {
        iTeamRepository.save(team);
    }
}
