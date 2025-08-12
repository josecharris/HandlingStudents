package com.edu.uptc.handlingstudent.model;

public class Student {
	private String code;
	private String name;
	private String career;
	private int numberSemester;
	private int age;
	private String gender;
	
	public Student() {
		
	}

	public Student(String code, String name, String career, int numberSemester, int age, 
			String gender) {
		this.code = code;
		this.name = name;
		this.career = career;
		this.numberSemester = numberSemester;
		this.age = age;
		this.gender = gender;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public int getNumberSemester() {
		return numberSemester;
	}

	public void setNumberSemester(int numberSemester) {
		this.numberSemester = numberSemester;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
