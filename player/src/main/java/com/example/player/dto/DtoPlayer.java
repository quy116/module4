package com.example.player.dto;

import com.example.player.model.Position;
import com.example.player.model.Status;
import com.example.player.model.Team;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class DtoPlayer implements Validator {
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
    private Status status;

    public DtoPlayer() {
    }

    public DtoPlayer(int id, String code, String fullName, String date, String experience, String img, Team team, Position position, Status status) {
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

    public DtoPlayer(String code, String fullName, String date, String experience, String img, Team team, Position position, Status status) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
