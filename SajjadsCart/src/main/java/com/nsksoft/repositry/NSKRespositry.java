package com.nsksoft.repositry;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nsksoft.bean.Category;

@Component
public class NSKRespositry {

	@Autowired
	SessionFactory factory;
	
	List list;
	String hql_fro_retrive_all_details="SELECT i.item_name,i.price,b.brand_name,c.cat_name FROM Category c INNER JOIN Brand b  ON c.cat_id=b.cat_id INNER JOIN Item i ON i.brand_id=b.brand_id";
	Session session;


	@Transactional
	public void saveCatBrandItems(Category cat) {
		// TODO Auto-generated method stub
	
		session=factory.getCurrentSession();
		session.save(cat);
		
	}


	@Transactional
	public List getDeta() {
		
		session=factory.getCurrentSession();
		Criteria  q=session.createCriteria(Category.class);
		list=q.list();
		
		return list;
	}
	
	
	
	
}
