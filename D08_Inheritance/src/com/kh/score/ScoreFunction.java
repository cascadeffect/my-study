package com.kh.score;

import java.util.Scanner;

public class ScoreFunction {

	private int kor;
	private int eng;
	private int math;

	public void printMainMenu() {
		System.out.println("===== 메인 메뉴 =====");
		System.out.println("1. 성적 입력");
		System.out.println("2. 성적 출력");
		System.out.println("3. 종료");
		System.out.print("선택>> ");
	}

	public void insertScore() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 성적 입력 =====");
		System.out.print("국어>> ");
		this.kor = sc.nextInt();
		System.out.print("영어>> ");
		this.eng = sc.nextInt();
		System.out.print("수학>> ");
		this.math = sc.nextInt();
	}

	public void printScore() {
		int sum = kor + eng + math;
		double avg = (double) sum / 3;
		System.out.println("===== 성적 출력 =====");
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		System.out.println("총점: " + sum);
		System.out.printf("평균: %.2f\n", avg);
	}
}
