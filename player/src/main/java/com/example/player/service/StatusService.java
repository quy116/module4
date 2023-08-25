package com.example.player.service;

import com.example.player.model.Status;
import com.example.player.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusService  implements IStatusService{
    @Autowired
    private IStatusRepository iStatusRepository;
    @Override
    public List<Status> list() {
        return iStatusRepository.findAll();
    }
}
