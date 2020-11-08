package com.banterboard.banterboardbackend.api.controller;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.repositories.BanterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/banter")
public class BanterController {

    private static Logger logger = LoggerFactory.getLogger(BanterController.class);


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

        logger.info("Saved Banter with ID: {}, Context: {}, Story: {} at {}.", banter.getId(), banter.getContext(),
                banter.getStory(), banter.getTime());
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
        logger.info("Querying all Banters.");
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
        logger.info("Retrieving Banter with ID: {}", id);
        return banterRepository.findById(id).get();
    }


    /**
     * Example Curl:
     *
     curl -X PUT \
     -H "Content-Type: application/json" \
     --data '{"context":"Jason was talking about an ex.","story":"He said, first of all I totally deserve to have someone like this in my life"}' \
     http://localhost:8080/banter-board/api/banter/3
     *
     * @param banter
     */
    @PutMapping(value = "/{id}", consumes = "application/json")
    public void updateBanter(@PathVariable String id, @RequestBody Banter banter){
        logger.debug("Found Banter for ID: {}", id);
        Banter banterToUpdate = getBanter(id);
        logger.info("Updating Banter for ID: {}. Previous context was: {}, new context is {}. Previous story was: {}, new story is {}",
                banterToUpdate.getId(), banterToUpdate.getContext(), banter.getContext(), banterToUpdate.getStory(),
                banter.getStory());
        banterToUpdate.setStory(banter.getStory());
        banterToUpdate.setContext(banter.getContext());
        banterRepository.save(banterToUpdate);
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
        logger.info("Deleting Banter for ID: {}", id);
        banterRepository.deleteById(id);
    }
}

