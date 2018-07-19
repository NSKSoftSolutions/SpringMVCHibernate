package com.spring.repositories;

import java.util.List;

import com.spring.bean.UploadFile;
import com.spring.bean.User;

public interface Repositry {

	int saveuser_info(User user);

	int check_user(String email, Long mobile);

	List valid_user(Long mobile, String password);

	int saveuser_file_info(UploadFile file);
	

}
