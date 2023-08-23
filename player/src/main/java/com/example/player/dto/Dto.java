package com.example.player.dto;

import com.example.player.model.Position;
import com.example.player.model.Team;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class Dto implements Validator {
    private int id;
    @NotBlank(message = "hello")
    private String code;
    @Size(min = 5,max = 100,message = "nhập 5 đến 100 ký tự")
    private String fullName;
    @Min(value = 16,message = "lớn hơn 16")
    private String date;
    @Pattern(regexp = "^[1-9]\\d*$", message = "là số nguyên dương")
    private String experience;
    //    private String position;
    private String img;
    private Team team;
    private Position position;

    public Dto() {
    }

    public Dto(int id, String code, String fullName, String date, String experience, String img, Team team, Position position) {
        this.id = id;
        this.code = code;
        this.fullName = fullName;
        this.date = date;
        this.experience = experience;
        this.img = img;
        this.team = team;
        this.position = position;
    }

    public Dto(String code, String fullName, String date, String experience, String img, Team team, Position position) {
        this.code = code;
        this.fullName = fullName;
        this.date = date;
        this.experience = experience;
        this.img = img;
        this.team = team;
        this.position = position;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
