package com.nsksoft.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	private int cat_id;
	private String cat_name;
	@OneToMany(targetEntity=Brand.class,cascade=CascadeType.ALL)
	@JoinColumn(name="cat_id")
	private Set<Brand> branddetails;
	
	public Set<Brand> getBranddetails() {
		return branddetails;
	}
	public void setBranddetails(Set<Brand> branddetails) {
		this.branddetails = branddetails;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	
	
	
}
