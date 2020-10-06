package com.banterboard.banterboardbackend.api.controller;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.repositories.BanterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/banter")
public class BanterController {

    private BanterRepository banterRepository;

    @Autowired
    BanterController(BanterRepository banterRepository) {
        this.banterRepository = banterRepository;
    }

    /**
     *Example Curl:
     *
     * curl -X GET http://localhost:8080/banter-board/api/banter
     *
     * @return
     */
    @GetMapping
    public List<Banter> getBanters() {
        return banterRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Banter getBanter(@PathVariable String id){
        return banterRepository.findById(id).get();
    }

    @PostMapping
    public void createBanter(@RequestBody Banter banter) {
        banter.setId(UUID.randomUUID().toString());
        banterRepository.save(banter);
    }

    @PutMapping("/{id}")
    public void updateBanter(@RequestBody Banter banter){
        //TODO not sure how this should work
        banterRepository.save(banter);
    }

    @DeleteMapping("/{id}")
    public void deleteBanter(@PathVariable String id){
        banterRepository.deleteById(id);
    }
}

