package com.kh.student;

import java.util.Scanner;

public class ManageStudent {

	Student student;

	ManageStudent() {
		student = new Student();
	}

	public void showMenu() {
		System.out.println("==== 학생 성적관리 프로그램 ====");
		System.out.println("1. 학생 성적 입력");
		System.out.println("2. 학생 성적 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print("선택>> ");
	}

	public void insertInformation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= 학생 정보 입력 =======");
		System.out.print("학생 이름>> ");
		String name = sc.next();
		System.out.print("국어 점수>> ");
		int kor = sc.nextInt();
		System.out.print("영어 점수>> ");
		int eng = sc.nextInt();
		System.out.print("수학 점수>> ");
		int math = sc.nextInt();
		// private 멤버변수에 직접 접근 불가 => setter를 이용하여 접근
		student.setName(name);
		student.setScore(kor, eng, math);
	}

	public void printResult() {
		System.out.println("======= 학생 정보 출력 =======");
		System.out.println("학생 이름: " + student.getName());
		System.out.println("국어 점수: " + student.getKor());
		System.out.println("영어 점수: " + student.getEng());
		System.out.println("수학 점수: " + student.getMath());
		System.out.println("총점: " + student.printSum());
		System.out.printf("평균: %.2f\n", student.printAvg());
		System.out.println("============================");
	}
}
