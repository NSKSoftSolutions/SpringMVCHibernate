package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.bean.UploadFile;
import com.spring.repositories.Repositry;

public class ServiceImpl implements Service {

	@Autowired
	Repositry repo;
	
	
	public int savefile(UploadFile uploadFile) {
		// TODO Auto-generated method stub
	   int result=repo.saveImage_information(uploadFile);
		 
		return result;
	}
	

	
}
