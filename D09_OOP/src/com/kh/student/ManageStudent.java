package com.kh.student;

import java.util.Scanner;

public class ManageStudent { // 입력 받고 배열에 저장
	private Student[] student; // 멤버 변수: Student 타입의 객체를 담을 수 있는 배열 student 선언

	public ManageStudent() {
		student = new Student[3]; // 생성자: 객체 배열 student(멤버 변수)의 크기를 3으로 초기화
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
		for (int i = 0; i < student.length; i++) {

			// setter 사용 코드
			student[i] = new Student(); // 중요 - 객체 배열 내 공간에 Student 타입 객체 생성
			System.out.print("학생 이름>> ");
			student[i].setName(sc.next()); // setter 사용
			System.out.print("국어 점수>> ");
			student[i].setKor(sc.nextInt()); // setter 사용
			System.out.print("영어 점수>> ");
			student[i].setEng(sc.nextInt()); // setter 사용
			System.out.print("수학 점수>> ");
			student[i].setMath(sc.nextInt()); // setter 사용
			System.out.println("------------------");

			// 생성자 사용 코드
//			System.out.print("이름>> ");
//			String name = sc.next();
//			System.out.print("국어 점수>> ");
//			int kor = sc.nextInt();
//			System.out.print("영어 점수>> ");
//			int eng = sc.nextInt();
//			System.out.print("수학 점수>> ");
//			int math = sc.nextInt();
//			student[i] = new Student(name, kor, eng, math); // 생성자 사용
		}
	}

	public void printInfo() {
		System.out.println("====== 학생 정보 출력 ======");

		for (int i = 0; i < student.length; i++) {
			System.out.println(i + 1 + "번째 학생: " + student[i].getName());
			System.out.println("국어 점수: " + student[i].getKor());
			System.out.println("영어 점수: " + student[i].getEng());
			System.out.println("수학 점수: " + student[i].getMath());
			System.out.println("총점: " + student[i].showTotal());
			System.out.printf("평균: %.2f\n", student[i].showAvg());
			System.out.println("------------------");
		}
	}
}
