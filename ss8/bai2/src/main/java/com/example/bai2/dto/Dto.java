package com.example.bai2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class Dto implements Validator {
    private String nameMusic;
    private String nameArtist;
    private String typeMusic;

    public Dto() {
    }

    public Dto(String nameMusic, String nameArtist, String typeMusic) {
        this.nameMusic = nameMusic;
        nameArtist = nameArtist;
        this.typeMusic = typeMusic;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Dto dto = (Dto) target;

        if (dto.getNameMusic() == null || dto.getNameMusic().isEmpty()) {
            errors.rejectValue("nameMusic", null, "Tên bài hát không được để trống");
        }

        if (dto.getNameArtist() == null || dto.getNameArtist().isEmpty()) {
            errors.rejectValue("nameArtist", null, "Tên nghệ sĩ không được để trống");
        }
        if (dto.getNameMusic().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}$")) {
            errors.rejectValue("nameMusic", null, "k dung regex");
        }
        if (dto.getNameArtist().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}$")) {
            errors.rejectValue("nameArtist", null, "k dung regex");
        }
        String genre = dto.getTypeMusic();
        if (genre == null || genre.isEmpty()) {
            errors.rejectValue("typeMusic", null, "Thể loại nhạc không được để trống");
        } else if (genre.length() > 1000) {
            errors.rejectValue("typeMusic", null, "Thể loại nhạc không được vượt quá 1000 ký tự");
        } else if (!genre.matches("^[^!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|<>/?`~]*$")) {
            errors.rejectValue("typeMusic", null, "Thể loại nhạc không được chứa các ký tự đặc biệt");
        }
    }


}
