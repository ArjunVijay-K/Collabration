package com.second.collabrationback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.second.collabrationback.DAO.JobsDAO;
import com.second.collabrationback.Model.Jobs;

@RestController
public class JobController {
	
	@Autowired
	private JobsDAO jobsDAO;

	@GetMapping("/jobs")
	public List getJobs() {
		return jobsDAO.list();
	}
	
	@GetMapping("/jobs/{id}")
	public ResponseEntity getJob(@PathVariable("id") String id) {

		Jobs job = jobsDAO.get(id);
		if (job == null) {
			return new ResponseEntity("No Job found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(job, HttpStatus.OK);
	}
	
	@PostMapping("/jobs")
	public ResponseEntity createjob(@RequestBody Jobs job) {

		jobsDAO.saveOrUpdate(job);

		return new ResponseEntity(job, HttpStatus.OK);
	}
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity deleteJob(@PathVariable String id) {
		Jobs job=jobsDAO.get(id);
 		if (job==null) {
			return new ResponseEntity("No Job found for ID " + id, HttpStatus.NOT_FOUND);
		}
 		jobsDAO.delete(id);
		return new ResponseEntity(id, HttpStatus.OK);

	}
	@PutMapping("/jobs/{id}")
	public ResponseEntity updateJob(@PathVariable String id, @RequestBody Jobs job) {

		job = jobsDAO.saveOrUpdate(job);

		if (null == job) {
			return new ResponseEntity("No Job found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(job, HttpStatus.OK);
	}
	
}
