package com.example.bai2.service;

import com.example.bai2.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> showList();

    void save(Music music);
}
