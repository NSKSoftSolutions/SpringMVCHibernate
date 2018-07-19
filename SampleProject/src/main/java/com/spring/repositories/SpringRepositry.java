package com.spring.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bean.UploadFile;
import com.spring.bean.User;
import com.spring.hqlconstants.HQLConstants;

@Component
public class SpringRepositry implements Repositry {

	@Autowired
	SessionFactory factory;

	Session session;

	@Transactional
	public int saveUserDetails(User user) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		int i = (Integer) session.save(user);
		return i;
	}

	@Transactional
	public int saveuser_info(User user) {
		// TODO Auto-generated method stub

		session = factory.openSession();
		int i = (Integer) session.save(user);
		return i;
	}

	@Transactional
	public int check_user(String email, Long mobile) {
		// TODO Auto-generated method stub

		session = factory.openSession();
		Query query = session.createQuery(HQLConstants.check_user);
		query.setParameter(0, mobile);
		query.setParameter(1, email);
		List res = query.list();
		int r = res.size();
		return r;
	}

	public List valid_user(Long mobile, String password) {
		// TODO Auto-generated method stub

		session = factory.openSession();
		Query q = session.createQuery(HQLConstants.validate_user_login);
		q.setParameter(0, mobile);
		q.setParameter(1, password);
		List list = q.list();
		int s = list.size();
		return list;
	}

	@Transactional
	public int saveuser_file_info(UploadFile file) {
		// TODO Auto-generated method stub

		session = factory.openSession();
		int result = (Integer) session.save(file);
		return result;
	}

}
