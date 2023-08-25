package com.example.player.aop;

import com.example.player.dto.DtoPlayer;
import com.example.player.model.PlayerSoccer;
import com.example.player.service.IPlayerService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @Autowired
    private IPlayerService iPlayerService;

    @Pointcut("execution(* com.example.player.controller.PlayerController.create(..))&&args(dtoPlayer,*,*,*)")
    public void getAllUpdate(DtoPlayer dtoPlayer) {
    }

    @After(value = "getAllUpdate(dtoPlayer)", argNames = "dtoPlayer")
    public void printUpdate(DtoPlayer dtoPlayer) {
        int count = 0;
        count++;
       boolean status = true;
       if (dtoPlayer.getStatus().getId() == 1){
           status = false;
       }
        System.out.println("Player's Status" + dtoPlayer.getFullName() + " has been converted to " + (status ? "Register Play" : "UnRegister play"));
        System.out.println("The number of registered players is: " + count);
    }
}
