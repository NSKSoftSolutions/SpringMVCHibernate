package com.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.UploadFile;
import com.spring.services.Service;

@Controller
public class MyController {

	ModelAndView model_and_view;
	@Autowired
	Service service;
	String path;

	UploadFile uploadFile;

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public ModelAndView getEmployees(@ModelAttribute("f") UploadFile f, HttpServletRequest request,
			@RequestParam CommonsMultipartFile[] fileUpload) throws IOException {

		model_and_view = new ModelAndView();

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				path = "E:/PracticedExamples/spring realtime example/FileUploadExample/WebContent/images/"
						+ aFile.getOriginalFilename();

				if (!aFile.getOriginalFilename().isEmpty()) {
					BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(path)));

					outputStream.write(aFile.getBytes());
					outputStream.flush();
					outputStream.close();
				}
				uploadFile = new UploadFile();
				uploadFile.setFileName(aFile.getOriginalFilename());
				uploadFile.setData(aFile.getBytes());
				uploadFile.setFirst_name(request.getParameter("first_name"));
				uploadFile.setLast_name(request.getParameter("last_name"));
				uploadFile.setEmail(request.getParameter("email"));
				uploadFile.setImage_path(path);

				int saved = service.savefile(uploadFile);

				if (saved > 0) {
					model_and_view.addObject("uploadFile", uploadFile);
					model_and_view.setViewName("success");
				}

				else {
					model_and_view.setViewName("error");
				}

			}

		}

		return model_and_view;
	}

}