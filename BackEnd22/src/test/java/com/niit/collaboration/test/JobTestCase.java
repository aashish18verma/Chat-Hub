package com.niit.collaboration.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;

public class JobTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Job job;
	@Autowired
	private static JobDAO jobDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		job = (Job) context.getBean("job");

		jobDAO = (JobDAO) context.getBean("jobDAO");

	}

	@Test
	public void createJobTestCase() {
		job.setId(3004);
		job.setTitle("My job");

		job.setDescription("colloboartion job");

		boolean flag = jobDAO.save(job);
		Assert.assertEquals("createJobTestCase", true, flag);
	}

	@Test
	public void deleteJobTestCase() {
		Job supplier = (Job) jobDAO.getJobByID(3004);
		boolean flag = jobDAO.delete(supplier);
		Assert.assertEquals("delete job test case", true, flag);
	}

	@Test
	public void updateJobTestCase() {
		Job job = (Job) jobDAO.getJobByID(3007);
		job.setId(3012);
		job.setTitle("MCameras");

		job.setDescription("collaboration job");

		boolean flag = jobDAO.update(job);

		Assert.assertEquals("update job test case", true, flag);
	}

}
