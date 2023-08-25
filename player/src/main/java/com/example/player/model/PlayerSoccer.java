package com.example.player.model;

import javax.persistence.*;

@Entity
public class PlayerSoccer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String fullName;
    private String date;
    private String experience;
    //    private String position;
    private String img;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public PlayerSoccer() {
    }

    public PlayerSoccer(int id, String code, String fullName, String date, String experience, String img, Team team, Position position, Status status) {
        this.id = id;
        this.code = code;
        this.fullName = fullName;
        this.date = date;
        this.experience = experience;
        this.img = img;
        this.team = team;
        this.position = position;
        this.status = status;
    }

    public PlayerSoccer(String code, String fullName, String date, String experience, String img, Team team, Position position, Status status) {
        this.code = code;
        this.fullName = fullName;
        this.date = date;
        this.experience = experience;
        this.img = img;
        this.team = team;
        this.position = position;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isStatus() {
        return true;
    }
}
