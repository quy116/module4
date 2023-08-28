package com.example.player.controller;

import com.example.player.dto.DtoPlayer;
import com.example.player.model.PlayerSoccer;
import com.example.player.service.IPlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/player/")
public class RestPlayerController {
    @Autowired
    private IPlayerService iPlayerService;

    @GetMapping("")
    public ResponseEntity<Page<PlayerSoccer>> showList(@RequestParam(defaultValue = "0", required = false) int page,
                                                       @RequestParam(defaultValue = "", required = false) String searchName,
                                                       @RequestParam(defaultValue = "2", required = false) int size,
                                                       Model model) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("fullName").ascending());
        Page<PlayerSoccer> playerSoccer = iPlayerService.showListService(pageable);
        if (playerSoccer.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerSoccer,HttpStatus.OK);
    }
    @GetMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
      boolean check =   iPlayerService.delete(id);
        if (check) {
            return new ResponseEntity<>("xoa ok",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("detail/{id}")
    public ResponseEntity<String> detail(@PathVariable int id) {

        PlayerSoccer playerSoccer = iPlayerService.findById(id).get();
        if (playerSoccer== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(" ok",HttpStatus.OK);
        }
    }
    @GetMapping("add")
    public ResponseEntity<?> add(@RequestBody DtoPlayer dtoPlayer) {
        PlayerSoccer playerSoccer = new PlayerSoccer();
        BeanUtils.copyProperties(dtoPlayer,playerSoccer);
        iPlayerService.add(playerSoccer);

            return new ResponseEntity<>("ok",HttpStatus.OK);

    }
    @GetMapping("edit/{id}")
    public ResponseEntity<?> edit( @PathVariable int id, @RequestBody DtoPlayer dtoPlayer) {
        PlayerSoccer playerSoccer = iPlayerService.findById(id).get();
        if (playerSoccer== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(dtoPlayer,playerSoccer);
        iPlayerService.add(playerSoccer);

        return new ResponseEntity<>("ok",HttpStatus.OK);

    }
}
