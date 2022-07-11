package com.kh.exercise;

import java.util.Scanner;

public class ForExercise {
	public void exercise1() {
		int sum = 0;
		for (int i = 1; i <= 100; i += 2) {
//			System.out.print(i + " "); // value check
			sum += i;
		}
		System.out.println("1~100 사이 홀수의 합: " + sum);
	}

	public void exercise2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~9 사이 숫자를 하나 입력하세요>> ");
		int num = sc.nextInt();
		if (num > 1 && num < 9)
			for (int i = 1; i <= 9; i++)
				System.out.println(num + " X " + i + " = " + (num * i));
		else
			System.out.println("1~9 사이의 양의 정수를 입력하셔야 합니다.");
	}

	public void exercise3() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
			System.out.print(i);
			if (i <= 9)
				System.out.print("+");
		}
		System.out.println("=" + sum);
	}
}
