package com.pojo;

import java.util.List;

public class Student {
	private int stu_id;
	private String name,sex,birth,classes;
	public Student(int stu_id, String name, String sex, String birth, String classes) {
		super();
		this.stu_id = stu_id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.classes = classes;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
}
