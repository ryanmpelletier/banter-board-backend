package com.banterboard.banterboardbackend;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.repositories.BanterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

@Component
public class BanterInitializer {

    @Value("${initialize-test-data}")
    Boolean initializeTestData;

    @Autowired
    BanterRepository banterRepository;

    public void initialize(){

        banterRepository.deleteAll();

        Banter banter1 = new Banter();
        banter1.setId(UUID.randomUUID().toString());
        banter1.setContext("Ryan was making pancakes.");
        banter1.setStory("Cole was like blah blah 'build pancakes'");
        banter1.setTime(Instant.now());

        Banter banter2 = new Banter();
        banter2.setId(UUID.randomUUID().toString());
        banter2.setContext("Rachelle was being congratulated about something and Ryan joined in, not knowing what it was");
        banter2.setStory("El jokingly said 'Ryan her dog died', not knowing that it actually had");
        banter2.setTime(Instant.now().plusSeconds(3600));

        Banter banter3 = new Banter();
        banter3.setId(UUID.randomUUID().toString());
        banter3.setContext("At El's house helping her move in.");
        banter3.setStory("Ryan made a joke that was really dumb.");
        banter3.setTime(Instant.now().plusSeconds(3600 * 2));


        banterRepository.saveAll(Arrays.asList(
                banter1,
                banter2,
                banter3
        ));


    }

}
