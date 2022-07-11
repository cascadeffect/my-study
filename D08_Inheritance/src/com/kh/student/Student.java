package com.kh.student;

public class Student {

	private String name;
	private int kor;
	private int eng;
	private int math;

	public Student() {
	}

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return this.name;
	}

	public int getKor() {
		return this.kor;
	}

	public int getEng() {
		return this.eng;
	}

	public int getMath() {
		return this.math;
	}

	public int printSum() {
		return this.kor + this.eng + this.math;
	}

	public double printAvg() {
		return (double) printSum() / 3;
	}

}
