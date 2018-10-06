package com.nsksoft.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	private int item_id;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private String item_name;
	private double price;
	private String warrenty;
	public String getWarrenty() {
		return warrenty;
	}
	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}
	
	
}
