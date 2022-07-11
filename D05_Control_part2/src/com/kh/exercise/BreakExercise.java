package com.kh.exercise;

import java.util.Scanner;

public class BreakExercise {
	public void exercise1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요>> ");
		int input = sc.nextInt();
		int sum = 0;
		for (int i = 1;; i++) {
			sum += i;
			if (i == input)
				break;
		}
		System.out.println("1부터 " + input + "까지 정수들의 합: " + sum);
	}

	public void exercise2() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 4 == 0)
				continue;
			sum += i;
		}
		System.out.println("4의 배수를 제외한 1부터 100까지 정수들의 합: " + sum);
	}
}
