package com.banterboard.banterboardbackend.api.controller;

import com.banterboard.banterboardbackend.database.service.IDatabaseService;
import com.banterboard.banterboardbackend.model.Banter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banter")
public class BanterController {

    final private static String rootUserId = "root";
    final private static String banterId = "banter";

    private IDatabaseService databaseService;

    @Autowired
    BanterController(IDatabaseService dbService) {
        this.databaseService = dbService;
    }

    @GetMapping
    public List<Banter> getBanters() {
        return databaseService.getAllBanters();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Banter getBanter(@PathVariable String id){
        return databaseService.getBanter(id);
    }

    @PostMapping
    public void createBanter(@RequestBody Banter banter) {
        databaseService.createBanter(banter);
    }

    @PutMapping("/{id}")
    public void updateBanter(@RequestBody Banter banter){
        databaseService.updateBanter(banter);
    }

    @DeleteMapping("/{id}")
    public void deleteBanter(@PathVariable String id){
        databaseService.deleteBanter(id);
    }
}

