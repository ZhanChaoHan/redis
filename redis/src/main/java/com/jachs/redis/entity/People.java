package com.jachs.redis.entity;

import java.io.Serializable;

/***
 * 
 * @author zhanchaohan
 *
 */
public class People implements Serializable{
	private String name;
	private int age;
	
	public People() {
		super();
	}
	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
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
	
}
