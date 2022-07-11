package com.kh.student;

public class Student { // 데이터 저장
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

	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	// getter
	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int showTotal() {
		return kor + eng + math;
	}

	public double showAvg() {
		return (double) showTotal() / 3;
	}
}
