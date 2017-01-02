package com.udemy.model;

import java.io.Serializable;

public class CourseModel implements Serializable {

	private static final long serialVersionUID = -4491053878639387473L;

	public CourseModel() {
	}

	public CourseModel(int id, String name, String description, int price, int hours) {
		this.setId(id);
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	private int id;
	private String name;
	private String description;
	private int price;
	private int hours;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
