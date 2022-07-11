package com.kh.student.practice;

import java.util.Scanner;

public class StudentConsole {
	StudentController stdController; // StudentController 타입 객체 stdController 선언

	public StudentConsole() {
		stdController = new StudentController(); // 객체 stdController 초기화
	}

	public void showMainMenu() {
		System.out.println("=== 학생 정보관리 프로그램 ===");
		System.out.println("1. 학생 정보 입력");
		System.out.println("2. 학생 정보 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 입력>> ");
	}

	public void insertInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 학생 정보 입력 ======");
		Student[] students = new Student[3]; // Student 타입 객체 배열 생성 및 크기 3으로 초기화
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(); // 배열 내에 Student 타입 객체 생성
			System.out.print("학생 이름>> ");
			students[i].setName(sc.next());
			System.out.print("국어 점수>> ");
			students[i].setKor(sc.nextInt());
			System.out.print("영어 점수>> ");
			students[i].setEng(sc.nextInt());
			System.out.print("수학 점수>> ");
			students[i].setMath(sc.nextInt());
			System.out.println("------------------");
		}
		stdController.setStudents(students); // 최종 저장
		// 저장 기능을 하는 StudentController의 setter를 이용하여 Student의 데이터에 접근(저장)
	}

	public void printInfo() {
		System.out.println("====== 학생 정보 출력 ======");

		// 1번 방법 - for문 안에서 Student 타입 (임시) 객체 생성 후,
		// 데이터가 저장된 stdController의 getStudents()와 인덱스를 이용하여
		// 각각의 배열 내 객체를 반환->대입
		for (int i = 0; i < stdController.getStudents().length; i++) {
			Student std = stdController.getStudents()[i];
			System.out.println(i + 1 + "번째 학생: " + std.getName());
			System.out.println("국어 점수: " + std.getKor());
			System.out.println("영어 점수: " + std.getEng());
			System.out.println("수학 점수: " + std.getMath());
			System.out.println("총점: " + std.showTotal());
			System.out.printf("평균: %.2f\n", std.showAvg());
			System.out.println("------------------");
		}
		// 2번 방법 - for문 밖에서 Student 타입 (임시) 객체 배열 생성 후,
		// 데이터가 저장된 stdController의 getStudents()로 객체 배열 반환->대입
//		Student[] students = stdController.getStudents();
//		for (int i = 0; i < students.length; i++) {
//			System.out.println(i + 1 + "번째 학생: " + students[i].getName());
//			System.out.println("국어 점수: " + students[i].getKor());
//			System.out.println("영어 점수: " + students[i].getEng());
//			System.out.println("수학 점수: " + students[i].getMath());
//			System.out.println("총점: " + students[i].showTotal());
//			System.out.printf("평균: %.2f\n", students[i].showAvg());
//			System.out.println("------------------");
//		}
	}
}
