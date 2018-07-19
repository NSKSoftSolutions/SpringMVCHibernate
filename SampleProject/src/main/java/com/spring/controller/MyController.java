package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.UploadFile;
import com.spring.bean.User;
import com.spring.services.Service;

@Controller
public class MyController {

	@Autowired
	Service service;
	private Object result;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser_info(@ModelAttribute User user) {

		ModelAndView mv = new ModelAndView();
		int already_exsit = service.check_user_details(user.getEmail(), user.getMobile());
		if (already_exsit > 0) {
			mv.addObject("user", user);
			mv.setViewName("useralredyexist");

		} else {

			int result = service.saveUserDetails(user);
			if (result > 0) {

				mv.addObject("user", user);
				System.out.println("user saved Successfully");
				mv.setViewName("success");

			} else {
				mv.setViewName("error");
			}
		}
		return mv;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView check_user_login(@RequestParam Long mobile, @RequestParam String password) {
		ModelAndView mv = new ModelAndView();
		List list = service.verify_user_credentails(mobile, password);
		mv.addObject("list", list);
		mv.setViewName("profile");
		return mv;
	}

	@RequestMapping(value = "/uploaddata", method = RequestMethod.POST)
	public ModelAndView saveFile(@ModelAttribute UploadFile file) {
		ModelAndView mv = new ModelAndView();
		 

		
		
		int i = service.saveUser_profile(file);

		
		
		
		mv.setViewName("profile");
		return mv;
	}

}
