package com.kh.exercise;

import java.util.Scanner;

public class WhileExercise {
	public void exercise1() {
		int i = 1, sum = 0;
		while (i <= 100) {
			sum += i;
			i += 2;
		}
		System.out.println("1~100 사이 홀수의 합: " + sum);
	}

	public void exercise2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~9 사이 숫자를 하나 입력하세요>> ");
		int num = sc.nextInt();
		if (num > 1 && num < 9) {
			int i = 1;
			while (i < 10) {
				System.out.println(num + " X " + i + " = " + (num * i));
				i++;
			}
		} else {
			System.out.println("1~9 사이의 양의 정수를 입력하셔야 합니다.");
		}
	}

	public void exercise3() {
		Scanner sc = new Scanner(System.in);

		int input = 0, sum = 0;

		while (true) {
			System.out.print("숫자를 입력하세요>> ");
			input = sc.nextInt();
			if (input == -1)
				break;
			sum += input;
		}
		System.out.println("입력하신 수의 합: " + sum);
	}

	public void exercise4() {
		Scanner sc = new Scanner(System.in);

		int input = 0, count = 0, sum = 0;

		while (true) {
			System.out.print("숫자를 입력하세요>> ");
			input = sc.nextInt();
			if (input == -1)
				break;
			count++;
			sum += input;
		}

		double avg = (double) sum / (double) count;

		if (count == 0)
			System.out.println("입력된 수가 없습니다.");
		else
			System.out.println("입력하신 정수의 개수는 " + count + "개이며, 평균은 " + avg + "입니다.");
	}
}
