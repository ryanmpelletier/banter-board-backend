package com.banterboard.banterboardbackend.model.builder;

import com.banterboard.banterboardbackend.model.Banter;

import java.time.Instant;
import java.util.UUID;

public class BanterBuilder {
    public Banter createBanter(){
        Banter banter = new Banter();
        banter.setId(UUID.randomUUID().toString());
        banter.setContext("");
        banter.setStory("");
        banter.setTimeInstant(Instant.now());
        return banter;
    }

}
