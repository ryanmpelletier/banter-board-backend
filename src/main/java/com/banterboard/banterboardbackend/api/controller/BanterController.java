
package com.banterboard.banterboardbackend.api.controller;

import com.banterboard.banterboardbackend.database.service.IDatabaseService;
import com.banterboard.banterboardbackend.model.Banter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BanterController {

    @Autowired
    private IDatabaseService databaseService;

    @GetMapping("/banter")
    public List<Banter> getMessage(){
        return databaseService.getAllBanters();
    }

}

