package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.bean.UploadFile;
import com.spring.bean.User;
import com.spring.repositories.Repositry;

public class ServiceImpl implements Service {

	@Autowired
	Repositry repo;
	int result;

	public int saveUserDetails(User user) {
		// TODO Auto-generated method stub
		int i = repo.saveuser_info(user);

		return i;
	}

	public int check_user_details(String email, Long mobile) {
		// TODO Auto-generated method stub

		int i = repo.check_user(email, mobile);

		return i;
	}

	public List verify_user_credentails(Long mobile, String password) {
		// TODO Auto-generated method stub
		List result = repo.valid_user(mobile, password);

		return result;
	}

	public int saveUser_profile(UploadFile file) {
		// TODO Auto-generated method stub

		int res=repo.saveuser_file_info(file);
		
		return res;
	}

}
