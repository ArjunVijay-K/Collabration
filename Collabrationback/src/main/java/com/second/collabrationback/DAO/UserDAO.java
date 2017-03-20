package com.second.collabrationback.DAO;

import java.util.List;

import com.second.collabrationback.Model.User;

public interface UserDAO {
	public List list();
	public User get(Long id);
	public User getbyUsername(String username);
	public User create(User user);
	public void delete(Long id);
	public User update(User user);

}
