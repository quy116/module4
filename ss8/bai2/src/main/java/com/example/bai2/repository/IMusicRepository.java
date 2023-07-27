package com.example.bai2.repository;

import com.example.bai2.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music,Integer> {
}
