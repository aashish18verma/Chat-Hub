package com.niit.collaboration.daoimpl;



import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.JobApplicationDAO;
import com.niit.collaboration.model.JobApplication;


@Transactional
@Repository("jobapplicationDAO")
public class JobApplicationDAOImpl implements JobApplicationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	

	@SuppressWarnings("unchecked")
	public List<JobApplication> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<JobApplication> jobapplication = session.createQuery("from JobApplication").list();
		tx.commit();
		session.flush();
		session.close();
		return jobapplication;
	}

	public boolean save(JobApplication jobapplication) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(jobapplication);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(JobApplication jobapplication) {
		try {
			System.out.println("JobApplicationDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//System.out.println("jobapplication=" + jobapplication.getJobApplication().getName() + "& jobapplication =" + jobapplication.getJobApplication().getName());


			session.update(jobapplication);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("JobApplicationDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(JobApplication jobapplication) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(jobapplication);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public JobApplication getJobApplicationByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// JobApplication jobapplication = (JobApplication) session.createQuery("from JobApplication where
		// id=" + id).uniqueResult();

		JobApplication jobapplication = (JobApplication) session.get(JobApplication.class, id);
		tx.commit();
		session.flush();
		session.close();
		return jobapplication;

	}

	
	
}
