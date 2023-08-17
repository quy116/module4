package com.example.demo4.repository;

import com.example.demo4.model.PlayerSoccer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository implements IPlayerRepository {
    private static List<PlayerSoccer> soccerList = new ArrayList<>();
    static {
        soccerList.add(new PlayerSoccer(1, "001", "Nguyen Phuc Quy", "11-06-2000", "10 nam", "coach", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnH0vyD3L439yMWtlGJ0nPQEXxhTwGOuOToA&usqp=CAU"));
        soccerList.add(new PlayerSoccer(2, "001", "Nguyen Phuc Quy", "11-06-2000", "10 nam", "coach", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnH0vyD3L439yMWtlGJ0nPQEXxhTwGOuOToA&usqp=CAU"));
        soccerList.add(new PlayerSoccer(3, "001", "Nguyen Phuc Quy", "11-06-2000", "10 nam", "coach", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnH0vyD3L439yMWtlGJ0nPQEXxhTwGOuOToA&usqp=CAU"));
        soccerList.add(new PlayerSoccer(4, "001", "Nguyen Phuc Quy", "11-06-2000", "10 nam", "coach", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnH0vyD3L439yMWtlGJ0nPQEXxhTwGOuOToA&usqp=CAU"));
        soccerList.add(new PlayerSoccer(5, "001", "Nguyen Phuc Quy", "11-06-2000", "10 nam", "coach", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnH0vyD3L439yMWtlGJ0nPQEXxhTwGOuOToA&usqp=CAU"));
    }

    @Override
    public List<PlayerSoccer> showList() {
        return soccerList;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < soccerList.size(); i++) {
            if (soccerList.get(i).getId()== id){
                soccerList.remove(i);
            }
        }
    }

    @Override
    public List<PlayerSoccer> findById(int id) {
        List<PlayerSoccer> list = new ArrayList<>();
        for (int i = 0; i < soccerList.size(); i++) {
            if (soccerList.get(i).getId()== id){
                list.add(showList().get(i));
            }
        }
        return list;
    }

    @Override
    public void add(PlayerSoccer playerSoccer) {
        soccerList.add(playerSoccer);
    }

    @Override
    public PlayerSoccer finByIdEdit(int id) {
        PlayerSoccer playerSoccer = new PlayerSoccer();
        for (int i = 0; i < soccerList.size(); i++) {
            if (soccerList.get(i).getId()== id){
                playerSoccer =soccerList.get(i);
                return playerSoccer;
            }
        }
        return null;
    }

    @Override
    public void edit(PlayerSoccer playerSoccer) {
        for (int i = 0; i < soccerList.size(); i++) {
            if (soccerList.get(i).getId()== playerSoccer.getId()){
               soccerList.set(i,playerSoccer);
            }
        }
    }


}
