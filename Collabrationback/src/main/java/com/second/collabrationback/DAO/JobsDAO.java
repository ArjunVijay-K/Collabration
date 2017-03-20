package com.second.collabrationback.DAO;

import java.util.List;

import com.second.collabrationback.Model.Jobs;

public interface JobsDAO {

public List<Jobs> list();
	
	public Jobs get(String jobsId);
	
	public Jobs saveOrUpdate(Jobs jobs);
		
	public void delete(String jobsId);
}
