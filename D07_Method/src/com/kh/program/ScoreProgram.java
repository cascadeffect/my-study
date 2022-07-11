package com.kh.program;

import java.util.Scanner;

public class ScoreProgram {
//	static int kor = 0, eng = 0, math = 0; // 전역변수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int kor = 0, eng = 0, math = 0;

		END: while (true) {
			printMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				// insertScore(); // 전역변수
				int[] scores = insertScore();
				kor = scores[0];
				eng = scores[1];
				math = scores[2];
				break;
			case 2:
				// printScore(); // 전역변수
				printScore(kor, eng, math);
				break;
			case 3:
				bye();
				break END;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	static void printMainMenu() {
		System.out.println("===== 메인 메뉴 =====");
		System.out.println("1. 성적 입력");
		System.out.println("2. 성적 출력");
		System.out.println("3. 종료");
		System.out.print("선택>> ");
	}

	static int[] insertScore() {
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[3];

		System.out.println("===== 성적 입력 =====");
		System.out.print("국어>> ");
		// kor = sc.nextInt();
		scores[0] = sc.nextInt();
		System.out.print("영어>> ");
		// eng = sc.nextInt();
		scores[1] = sc.nextInt();
		System.out.print("수학>> ");
		// math = sc.nextInt();
		scores[2] = sc.nextInt();
		return scores;
	}

	// static void printScore() { // 전역변수
	static void printScore(int kor, int eng, int math) {
		int sum = kor + eng + math;
		double avg = (double) sum / 3;
		System.out.println("===== 성적 출력 =====");
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		System.out.println("총점: " + sum);
		System.out.printf("평균: %.2f\n", avg);
	}

	static void bye() {
		System.out.println("Good Bye~");
	}

}
