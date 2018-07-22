package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.JobApplication;

public interface JobApplicationDAO {
	public List<JobApplication> list();
	public boolean save(JobApplication jobapplication);
	public boolean update(JobApplication jobapplication);
	public boolean delete(JobApplication jobapplication);
	public JobApplication getJobApplicationByID(int id);

}
