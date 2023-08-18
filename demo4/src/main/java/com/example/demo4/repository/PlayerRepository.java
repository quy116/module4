package com.example.demo4.repository;

import com.example.demo4.model.PlayerSoccer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository implements IPlayerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PlayerSoccer> showList() {
        TypedQuery<PlayerSoccer> query = entityManager.createQuery("from PlayerSoccer", PlayerSoccer.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void delete(int id) {
        PlayerSoccer playerSoccer1 = finByIdEdit(id);
        entityManager.remove(playerSoccer1);
    }

    @Override
    public List<PlayerSoccer> findById(int id) {
        List<PlayerSoccer> list = new ArrayList<>();
        PlayerSoccer playerSoccer = entityManager.find(PlayerSoccer.class, id);
        list.add(playerSoccer);
        return list;
    }
    @Transactional
    @Override
    public void add(PlayerSoccer playerSoccer) {
        try {
            entityManager.persist(playerSoccer);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public PlayerSoccer finByIdEdit(int id) {
        PlayerSoccer playerSoccer = entityManager.find(PlayerSoccer.class, id);
        return playerSoccer;
    }
    @Transactional
    @Override
    public void edit(PlayerSoccer playerSoccer) {
        PlayerSoccer playerSoccer1 = finByIdEdit(playerSoccer.getId());
        playerSoccer1.setCode(playerSoccer.getCode());
        playerSoccer1.setFullName(playerSoccer.getFullName());
        playerSoccer1.setDate(playerSoccer.getDate());
        playerSoccer1.setExperience(playerSoccer.getExperience());
        playerSoccer1.setImg(playerSoccer.getImg());
        playerSoccer1.setPosition(playerSoccer.getPosition());
        entityManager.merge(playerSoccer1);
    }


}
