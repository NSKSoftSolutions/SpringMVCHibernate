package com.nsksoft.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Brand {

	@Id
	private int brand_id;
	private String brand_name;
    @OneToMany(targetEntity=Item.class,cascade=CascadeType.ALL)
    @JoinColumn(name="brand_id")
	private Set<Item> itemdetails;
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public Set<Item> getItemdetails() {
		return itemdetails;
	}
	public void setItemdetails(Set<Item> itemdetails) {
		this.itemdetails = itemdetails;
	}
	
	
}
