package com.second.collabrationback.DAO;

import java.util.List;

import com.second.collabrationback.Model.Forum;

public interface ForumDAO {
	
public List<Forum> list();
	
	public Forum get(String forumId);
	
	public Forum saveOrUpdate(Forum forum);
		
	public void delete(String forumId);

}
