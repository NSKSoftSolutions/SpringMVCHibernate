package com.nsksoft.control;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nsksoft.bean.Brand;
import com.nsksoft.bean.Category;
import com.nsksoft.bean.Item;
import com.nsksoft.repositry.NSKRespositry;

@Controller
public class OrderController {

	@Autowired
	NSKRespositry repo;
	
	List listdet;
	
	@RequestMapping("/catitem")
	public ModelAndView saveItemsInCat(@ModelAttribute Category cat,@ModelAttribute Item item,@ModelAttribute Brand brand)
	{
		ModelAndView mv=new ModelAndView();
	    
		Set s1=new HashSet();
		    s1.add(item); 
		
		
		brand.setItemdetails(s1);
		
		Set s2=new HashSet();
		    s2.add(brand);
		    
	    cat.setBranddetails(s2);	   
		
	    mv.addObject("item", item);
	    mv.addObject("brand", brand);
	    mv.addObject("cat",cat);
		repo.saveCatBrandItems(cat);
		
		
		
		mv.setViewName("success");
		
		return mv;
		
	}
	
	@GetMapping("/getall")
	public ModelAndView getAllDet()
	{
		ModelAndView mv=new ModelAndView();
		listdet=repo.getDeta();
		System.out.println(listdet.size());
		mv.addObject("listdet",listdet);
		mv.setViewName("getsuccess");
		
		
		return mv;
			
	}
	
		
}

