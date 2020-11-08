package com.banterboard.banterboardbackend.api.controller;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.model.Comment;
import com.banterboard.banterboardbackend.model.Reaction;
import com.banterboard.banterboardbackend.repositories.BanterRepository;

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
     * curl -X DELETE http://localhost:8080/banter-board/api/banter/93df3cf9-6c5b-44f2-ba26-6257efd98b2
     *
     * @return
     */
    @DeleteMapping("/{id}")
    public void deleteBanter(@PathVariable String id){
        banterRepository.deleteById(id);
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
        Banter banterToUpdate = getBanter(id);
        banterToUpdate.setStory(banter.getStory());
        banterToUpdate.setContext(banter.getContext());
        banterRepository.save(banterToUpdate);
    }
    
    /**
     * Get a banter by an id and return its reactions
     * 
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}/reactions", produces = "application/json")
    public Set<Reaction> getBanterReactions(@PathVariable String id){
        Banter foundBanter = getBanter(id);
        Set<Reaction> reactions = new HashSet<Reaction>();
        if (foundBanter != null) {	
        	reactions = foundBanter.getReactions();
        }
        return reactions;
    }
    /**
     * Get a banter by an id and add a reaction
     */
    @PutMapping(value = "/{id}/reactions/{reactionId}", consumes = "application/json")
    public void createReaction(@PathVariable String id,@PathVariable String reactionId, @RequestBody Reaction reaction){
        Banter banterToFind = getBanter(id);
        if (banterToFind != null) {	
        	Set<Reaction> reactions = banterToFind.getReactions();
        	if (reactions == null) reactions = new HashSet<Reaction>();
        	reactions.add(reaction);
        	banterRepository.save(banterToFind);
        }
    }
    /**
     * Get a banter by an id and delete the reaction
     * 
     * @param id
     * @param reactionId
     */
    @DeleteMapping("/{id}/reactions/{reactionId}")
    public void deleteBanterReaction(@PathVariable String id,@PathVariable String reactionId){
    	Banter banterToFind = getBanter(id);
    	if (banterToFind != null) {
    		// remove reaction from set
    		banterToFind.getReactions().removeIf(comment -> comment.getId().contentEquals(reactionId));
        	banterRepository.save(banterToFind);
    	}
    }
    /**
     * Get a banter by an id and return its comments
     * 
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}/comments", produces = "application/json")
    public Set<Comment> getBanterComments(@PathVariable String id){
        Banter foundBanter = getBanter(id);
        Set<Comment> comments = new HashSet<Comment>();
        if (foundBanter != null) {	
        	comments = foundBanter.getComments();
        }
        return comments;
    }
    /**
     * Get a banter by an id and add a comment
     * 
     * @param id
     * @param commentId
     * @param comment
     */
    @PutMapping(value = "/{id}/comments/{commentId}", consumes = "application/json")
    public void createComment(@PathVariable String id,@PathVariable String commentId, @RequestBody Comment comment){
        Banter banterToFind = getBanter(id);
        if (banterToFind != null) {
        	// add comment to set
        	banterToFind.getComments().add(comment);
        	banterRepository.save(banterToFind);
        }
    }
    /**
     * Get a banter by an id and delete the comment
     * 
     * @param id
     * @param commentId
     */
    @DeleteMapping("/{id}/comments/{commentId}")
    public void deleteBanterComment(@PathVariable String id,@PathVariable String commentId){
    	Banter banterToFind = getBanter(id);
    	if (banterToFind != null) {
    		// remove comment from set
    		banterToFind.getComments().removeIf(comment -> comment.getId().contentEquals(commentId));
        	banterRepository.save(banterToFind);
    	}
    }
}

