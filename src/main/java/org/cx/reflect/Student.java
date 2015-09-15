package org.cx.reflect;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	
	private String name;
	
	public String address;
	
	public List<String> list = new ArrayList<String>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student() {
		System.out.println("一个新对象");
	}
	
	public Student(int id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public int add(int a, int b) {
		return a + b;
	}

	public void welcomeStu(int id, String name) {
		System.out.println(name+"同学你的id是:"+id);
	}
}
