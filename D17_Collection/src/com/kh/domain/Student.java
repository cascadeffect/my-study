package com.kh.domain;

public class Student {
	private String name;
	private int score;

	public Student() {

	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() { // 사용된 객체에 저장된 데이터 확인용으로 사용
		return "Student [ name = " + name + ", score = " + score + " ]";
	}

	// 객체끼리 비교할 때는 주소값 말고 저장된 값을 비교해줘야
	@Override
	public int hashCode() {
		// 객체의 주소값이 아닌 name + score의 고유값으로 비교
		return (this.name + this.score).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// 객체의 경우에도 중복으로 저장되지 않게 하기 위해서
		// equals() 메소드를 재정의하여 비교하게 함
		if (obj instanceof Student) {
			Student std = (Student) obj;
			return this.hashCode() == std.hashCode();
		} else {
			return false;
		}
	}
}
