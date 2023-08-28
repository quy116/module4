package com.example.player.dto;

import java.util.HashMap;
import java.util.Map;

public class DtoCardPayer {
    private Map<DtoPlayer,Integer> map = new HashMap<>();

    public DtoCardPayer() {
    }

    public DtoCardPayer(Map<DtoPlayer, Integer> map) {
        this.map = map;
    }

    public Map<DtoPlayer, Integer> getMap() {
        return map;
    }

    public void setMap(Map<DtoPlayer, Integer> map) {
        this.map = map;
    }
    public void addPlayer(DtoPlayer dtoPlayer){
        if (map.containsKey(dtoPlayer)){
            Integer currentValue = map.get(dtoPlayer);
            map.replace(dtoPlayer,currentValue + 1);
        }else {
            map.put(dtoPlayer, 1);
        }
    }
}
