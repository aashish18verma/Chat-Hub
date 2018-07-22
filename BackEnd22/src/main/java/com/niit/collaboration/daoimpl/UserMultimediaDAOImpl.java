package com.niit.collaboration.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.niit.collaboration.config.ApplicationContextConfig;
import com.niit.collaboration.dao.UserMultimediaDAO;
import com.niit.collaboration.model.UserMultimedia;
import com.util.FileUtil;


@Transactional
@ComponentScan("com.niit.collaboration.daoimpl")
@Component
class UserMultimediaDAOImpl implements UserMultimediaDAO
{
	
	String path="D:\\ProjectDT1\\BackEnd\\images\\";

	public boolean saveUserMultimedia(UserMultimedia userMultimedia,MultipartFile  image) 
	{
		
		try 
		{
			SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
				
			session.save(userMultimedia);
			FileUtil.upload(path,  image,(userMultimedia.getMultimediaID()+image.getOriginalFilename()));
			
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUserMultimedia(UserMultimedia userMultimedia) {
		
		
		return false;
	}

	public List<UserMultimedia> getAllUserMultimedia() {
		
		
		
		
		return null;
	}

}
