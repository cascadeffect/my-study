package com.kh.student.practice;

public class StudentController {
	private Student[] students; // 멤버 변수: Student 타입 객체 배열 students 선언

	public StudentController() {
		students = new Student[3]; // 생성자: 객체 배열 students를 크기 3으로 초기화
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public Student[] getStudents() {
		return students;
	}
}
