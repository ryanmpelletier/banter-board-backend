package com.banterboard.banterboardbackend.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class Banter {
    @Id
    private String id;
    private Instant time;
    private String context;
    private String story;
    private Set<Reaction> reactions = new HashSet<Reaction>();
    private Set<Comment> comments = new HashSet<Comment>();

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

    public Set<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(Set<Reaction> reactions) {
        this.reactions = reactions;
    }

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
    
    
}
