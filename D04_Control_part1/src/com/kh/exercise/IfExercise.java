package com.kh.exercise;

import java.util.Scanner;

public class IfExercise {
	public void exercise1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요>> ");
		int num = sc.nextInt();
		if (num > 0) {
			if (num % 2 == 0) {
				System.out.println("짝수다.");
			} else {
				System.out.println("홀수다.");
			}
		} else {
			System.out.println("양수를 입력해주세요.");
		}
	}

	public void exercise2() {
		Scanner sc = new Scanner(System.in);

		System.out.print("중간고사 점수(20%)>> ");
		int midScore = sc.nextInt();
		System.out.print("기말고사 점수(30%)>> ");
		int finScore = sc.nextInt();
		System.out.print("과제 점수   (30%)>> ");
		int hwScore = sc.nextInt();
		System.out.print("출석 점수  (100%)>> ");
		int atdScore = sc.nextInt();

		double totScore = midScore * 0.2 + finScore * 0.3 + hwScore * 0.3 + atdScore;
		System.out.println("총점: " + totScore);

		if (atdScore > 20 * 0.7 && totScore >= 70) {
			System.out.println("Pass입니다!");
		} else {
			System.out.print("Fail입니다... ");
			if (totScore >= 70) {
				System.out.println("[출석 횟수 부족] (" + atdScore + "/20)");
			} else if (atdScore > 20 * 0.7) {
				System.out.println("[점수 미달] (" + totScore + "/70)");
			} else {
				System.out.println("[출석 횟수 부족] (" + atdScore + "/20) [점수 미달] (" + totScore + "/70)");
			}
		}
	}
}
