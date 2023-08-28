package com.example.player.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "status")
    private Set<PlayerSoccer> playerSoccerSet;

    public Status() {
    }

    public Status(int id, String name, Set<PlayerSoccer> playerSoccerSet) {
        this.id = id;
        this.name = name;
        this.playerSoccerSet = playerSoccerSet;
    }

    public Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PlayerSoccer> getPlayerSoccerSet() {
        return playerSoccerSet;
    }

    public void setPlayerSoccerSet(Set<PlayerSoccer> playerSoccerSet) {
        this.playerSoccerSet = playerSoccerSet;
    }
}
