package com.udemy.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonModel implements Serializable {
	
	private static final long serialVersionUID = -8352565233313457869L;

	public PersonModel() {	}
	
	@NotNull
	@Size(min=2, max=10)
	private String name;
	
	@NotNull
	@Min(18)
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public PersonModel(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
