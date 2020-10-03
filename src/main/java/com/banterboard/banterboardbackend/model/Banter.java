package com.banterboard.banterboardbackend.model;

import java.time.Instant;

public class Banter {
    private String id;
    private Instant timeInstant;
    private String context;
    private String story;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTimeInstant() {
        return timeInstant;
    }

    public void setTimeInstant(Instant timeInstant) {
        this.timeInstant = timeInstant;
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

}
