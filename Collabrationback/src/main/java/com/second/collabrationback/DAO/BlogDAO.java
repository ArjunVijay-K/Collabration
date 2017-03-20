package com.second.collabrationback.DAO;

import java.util.List;

import com.second.collabrationback.Model.Blog;

public interface BlogDAO {

public List<Blog> list();
	
	public Blog get(String blogId);
	
	public Blog saveOrUpdate(Blog blog);
		
	public void delete(String blogId);
}
