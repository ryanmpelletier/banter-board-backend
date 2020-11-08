package com.banterboard.banterboardbackend.model;

import org.springframework.data.annotation.Id;

public class Comment {
	@Id
	private String id;
	private String userId;
	private String banterId;
	private String comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
