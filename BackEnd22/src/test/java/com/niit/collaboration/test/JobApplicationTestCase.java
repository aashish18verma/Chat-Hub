package com.niit.collaboration.test;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.JobApplicationDAO;
import com.niit.collaboration.model.JobApplication;

public class JobApplicationTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static JobApplication jobpplication;
	@Autowired
	private static JobApplicationDAO jobpplicationDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		jobpplication = (JobApplication) context.getBean("jobpplication");

		jobpplicationDAO = (JobApplicationDAO) context.getBean("jobpplicationDAO");

	}

	@Test
	public void createJobApplicationTestCase() {
		jobpplication.setId(3004L);
		jobpplication.setStatus('Y');

		jobpplication.setRemarks("colloboartion jobpplication");

		boolean flag = jobpplicationDAO.save(jobpplication);
		Assert.assertEquals("createJobApplicationTestCase", true, flag);
	}

	@Test
	public void deleteJobApplicationTestCase() {
		JobApplication jobpplication = (JobApplication) jobpplicationDAO.getJobApplicationByID(3004);
		boolean flag = jobpplicationDAO.delete(jobpplication);
		Assert.assertEquals("delete jobpplication test case", true, flag);
	}

	@Test
	public void updateJobApplicationTestCase() {
		JobApplication jobpplication = (JobApplication) jobpplicationDAO.getJobApplicationByID(3007);
		jobpplication.setId(301L);
		jobpplication.setStatus('N');

		jobpplication.setRemarks("collaboration jobpplication");

		boolean flag = jobpplicationDAO.update(jobpplication);

		Assert.assertEquals("update jobpplication test case", true, flag);
	}

}
