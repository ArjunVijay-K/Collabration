package com.second.collabrationback.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "comment")
@Component
public class Comment {
	
	@Id
	@Column(name="CommentId")
	@GeneratedValue	
	private String CommentId;
	
	private String forumId;
	private String userId;
	private String userName;
	private String commends;
	public String getCommentId() {
		return CommentId;
	}
	public void setCommentId(String commentId) {
		CommentId = commentId;
	}
	public String getForumId() {
		return forumId;
	}
	public void setForumId(String forumId) {
		this.forumId = forumId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCommends() {
		return commends;
	}
	public void setCommends(String commends) {
		this.commends = commends;
	}
	
	/*@Generated(value = { "" })
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date date = new java.sql.Date(new java.util.Date().getTime());*/

	
}
