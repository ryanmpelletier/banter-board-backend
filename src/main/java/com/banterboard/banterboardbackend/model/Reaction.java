package com.banterboard.banterboardbackend.model;
import org.springframework.data.annotation.Id;


public class Reaction {
	@Id
	private String id;
	private String userId;
	private String banterId;
	private EReactionType reactionType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getBanterId() {
		return banterId;
	}
	public void setBanterId(String banterId) {
		this.banterId = banterId;
	}
	public EReactionType getReactionType() {
		return reactionType;
	}
	public void setReactionType(EReactionType reactionType) {
		this.reactionType = reactionType;
	}
	
}
