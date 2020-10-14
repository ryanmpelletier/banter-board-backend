package com.banterboard.banterboardbackend;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.model.Reaction;
import com.banterboard.banterboardbackend.repositories.BanterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class BanterInitializer {

    @Value("${initialize-test-data}")
    Boolean initializeTestData;

    @Autowired
    BanterRepository banterRepository;

    public void initialize(){

        banterRepository.deleteAll();

        Set<Reaction> banter1Reactions = new HashSet<>();
        banter1Reactions.add(new Reaction(Reaction.LAUGH_AT));
        banter1Reactions.add(new Reaction(Reaction.LAUGH_WITH));


        Banter banter1 = new Banter();
        banter1.setId("1");
        banter1.setContext("Ryan was making pancakes.");
        banter1.setStory("Cole was like blah blah 'build pancakes'");
        banter1.setTime(Instant.now());
        banter1.setReactions(banter1Reactions);

        Set<Reaction> banter2Reactions = new HashSet<>();
        banter2Reactions.add(new Reaction(Reaction.LAUGH_AT));
        banter2Reactions.add(new Reaction(Reaction.LAUGH_WITH));
        banter2Reactions.add(new Reaction(Reaction.LAUGH_AT));

        Banter banter2 = new Banter();
        banter2.setId("2");
        banter2.setContext("Rachelle was being congratulated about something and Ryan joined in, not knowing what it was");
        banter2.setStory("El jokingly said 'Ryan her dog died', not knowing that it actually had");
        banter2.setTime(Instant.now().plusSeconds(3600));
        banter2.setReactions(banter2Reactions);

        Banter banter3 = new Banter();
        banter3.setId("3");
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
