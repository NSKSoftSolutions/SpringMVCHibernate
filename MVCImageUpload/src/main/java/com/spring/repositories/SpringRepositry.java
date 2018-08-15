package com.spring.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.bean.UploadFile;

@Component
public class SpringRepositry implements Repositry {

	@Autowired
	SessionFactory factory;

	Session session;
	// uploading file

	
	public SpringRepositry(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
	}


	public int saveImage_information(UploadFile ufile) {
		// TODO Auto-generated method stub

		session = factory.openSession();
		int file_saved = (Integer) session.save(ufile);
		return file_saved;
	}

}
