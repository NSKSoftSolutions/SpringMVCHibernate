package com.spring.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Component
public class UploadFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int file_id;
	private String filename;
	private CommonsMultipartFile filedata;

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public CommonsMultipartFile getFiledata() {
		return filedata;
	}

	public void setFiledata(CommonsMultipartFile filedata) {
		this.filedata = filedata;
	}

}
