package com.example.bai2.service;

import com.example.bai2.model.Music;
import com.example.bai2.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository repository;
    @Override
    public List<Music> showList() {
//        return repository;
        return repository.findAll();
    }

    @Override
    public void save(Music music) {
        repository.save(music);
    }
}
