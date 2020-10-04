package com.banterboard.banterboardbackend;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.repositories.BanterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class BanterInitializer {

    @Value("${initialize-test-data}")
    Boolean initializeTestData;

    @Autowired
    BanterRepository banterRepository;

    public void initialize(){

        banterRepository.deleteAll();

        Banter banter = new Banter();
        banter.setId(UUID.randomUUID().toString());
        banter.setContext("Ryan was making pancakes.");
        banter.setStory("Cole was like blah blah 'build pancakes'");
        banter.setTimeInstant(Instant.now());

        banterRepository.save(banter);


    }

}
