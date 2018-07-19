package com.spring.services;

import java.util.List;

import com.spring.bean.UploadFile;
import com.spring.bean.User;

public interface Service {

	

	int saveUserDetails(User user);

	int check_user_details(String email, Long mobile);

	List verify_user_credentails(Long mobile, String password);

	int saveUser_profile(UploadFile file);

}
