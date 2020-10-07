package com.banterboard.banterboardbackend.model;

import org.springframework.data.annotation.Id;

import java.time.Instant;

public class Banter {
    @Id
    private String id;
    private Instant time;
    private String context;
    private String story;
//    private Map<String, LikeInfo> userIdToLikeInfoMap;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
//
//    public Map<String, LikeInfo> getUserIdToLikeInfoMap() {
//        return userIdToLikeInfoMap;
//    }
//
//    public void setUserIdToLikeInfoMap(Map<String, LikeInfo> userIdToLikeInfoMap) {
//        this.userIdToLikeInfoMap = userIdToLikeInfoMap;
//    }
}
