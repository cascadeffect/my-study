package com.kh.oop;

public class Person {
	private String citizenNo; // 속성 -> Field(필드)
	private String name;
	private int age;
	private char gender;
	private String phone;
	private String address;

	// 생성자
	// 1. 역할: 객체 생성 및 초기화
	// 2. 특징: 클래스명과 같은 이름의 메소드, 반환형 X
	public Person() {
	}

	public Person(String citizenNo, String name) {
		this.citizenNo = citizenNo;
		this.name = name;
	}

	// 기능 -> Method(메소드)
	// setter 메소드
	public void setCitizenNo(String citizenNo) {
		this.citizenNo = citizenNo;
	}

	// getter 메소드
	public String getCitizenNo() {
		return this.citizenNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getGender() {
		return this.gender;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}
}
