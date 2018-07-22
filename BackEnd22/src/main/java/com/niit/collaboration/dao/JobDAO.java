package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Job;

public interface JobDAO {
	public List<Job> list();
	public boolean save(Job job);
	public boolean update(Job job);
	public boolean delete(Job job);
	public Job getJobByID(int id);
	public Job getJobByTitle(String title);
}
