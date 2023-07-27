package com.example.bai2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String NameMusic;
    private String NameArtist;
    private String typeMusic;

    public Music() {
    }

    public Music(int id, String nameMusic, String nameArtist, String typeMusic) {
        this.id = id;
        NameMusic = nameMusic;
        NameArtist = nameArtist;
        this.typeMusic = typeMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return NameMusic;
    }

    public void setNameMusic(String nameMusic) {
        NameMusic = nameMusic;
    }

    public String getNameArtist() {
        return NameArtist;
    }

    public void setNameArtist(String nameArtist) {
        NameArtist = nameArtist;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }
}
