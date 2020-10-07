package com.banterboard.banterboardbackend.api.controller;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.repositories.BanterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
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
     * Example Curl:
     *
      curl -X POST \
        -H "Content-Type: application/json" \
        --data '{"context":"Jason was talking about an ex.","story":"He said, first of all I totally deserve to have someone like this in my life"}' \
        http://localhost:8080/banter-board/api/banter
     *
     * @param banter
     */
    @PostMapping(consumes = "application/json")
    public void createBanter(@RequestBody Banter banter) {
        banter.setId(UUID.randomUUID().toString());
        banter.setTime(Instant.now());
        banterRepository.save(banter);
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


    /**
     *Example Curl:
     *
     * curl -X GET http://localhost:8080/banter-board/api/banter/93df3cf9-6c5b-44f2-ba26-6257efd98b2
     *
     * @return
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    public Banter getBanter(@PathVariable String id){
        return banterRepository.findById(id).get();
    }


    /**
     *Example Curl:
     *
     * curl -X PUT http://localhost:8080/banter-board/api/banter/93df3cf9-6c5b-44f2-ba26-6257efd98b2
     *
     * @return
     */
    @PutMapping("/{id}")
    public void updateBanter(@RequestBody Banter banter){
        //TODO not sure how this should work
        banterRepository.save(banter);
    }


    /**
     *Example Curl:
     *
     * curl -X DELETE http://localhost:8080/banter-board/api/banter/93df3cf9-6c5b-44f2-ba26-6257efd98b2
     *
     * @return
     */
    @DeleteMapping("/{id}")
    public void deleteBanter(@PathVariable String id){
        banterRepository.deleteById(id);
    }
}

