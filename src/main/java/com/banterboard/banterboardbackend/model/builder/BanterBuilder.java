package com.banterboard.banterboardbackend.model.builder;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.model.LikeInfo;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BanterBuilder {
    public Banter createBanter() {
        Banter banter = new Banter();
        banter.setId(UUID.randomUUID().toString());
        banter.setContext("");
        banter.setStory("");
        banter.setTimeInstant(Instant.now());
        Map<String, LikeInfo> userIdToLikeInfoMap = new HashMap<>();
//        banter.setUserIdToLikeInfoMap(userIdToLikeInfoMap);
        return banter;
    }

    public Banter cloneBanter(Banter toBeCloned) {
        Banter cloned = new Banter();
        cloned.setId(toBeCloned.getId());
        cloned.setContext(toBeCloned.getContext());
        cloned.setStory(toBeCloned.getStory());
        cloned.setTimeInstant(toBeCloned.getTimeInstant());
        // shallow copy userIdToLikeInfoMap
//        cloned.setUserIdToLikeInfoMap(toBeCloned.getUserIdToLikeInfoMap());
        return cloned;
    }


}
