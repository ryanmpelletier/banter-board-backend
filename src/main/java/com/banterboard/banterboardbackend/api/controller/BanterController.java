package com.banterboard.banterboardbackend.api.controller;

import com.banterboard.banterboardbackend.database.service.IDatabaseService;
import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.model.builder.BanterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("")
    public List<Banter> getMessage() {
        return databaseService.getAllBanters();
    }

    @GetMapping("/create")
    public void createBanter() {
        Banter banter = new BanterBuilder().createBanter();
        banter.setContext("Test context");
        banter.setStory("Test story");
        databaseService.createBanter(banter);
    }
}

