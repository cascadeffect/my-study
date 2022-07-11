package com.kh.exercise;

import java.util.Scanner;

public class ControlExercise {
	public void exercise1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1 이상의 숫자를 입력하세요>> ");
		int input = sc.nextInt();

		if (input < 1)
			System.out.println("1 이상의 숫자를 입력해주세요.");
		else
			for (int i = 1; i <= input; i++)
				System.out.print(i + " ");
	}

	public void exercise2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1 이상의 숫자를 입력하세요>> ");
		int input = sc.nextInt();

		if (input < 1)
			System.out.println("1 이상의 숫자를 입력해주세요.");
		else
			for (int i = input; i > 0; i--)
				System.out.print(i + " ");
	}

	public void exercise3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요>> ");
		int input = sc.nextInt();
		int sum = 0;

		for (int i = 1; i <= input; i++) {
			sum += i;
			System.out.print(i);
			if (i == input)
				System.out.print(" = ");
			else
				System.out.print(" + ");
		}
		System.out.println(sum);
	}

	public void exercise4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자>> ");
		int first = sc.nextInt();
		System.out.print("두 번째 숫자>> ");
		int second = sc.nextInt();

		if (first < 1 || second < 1)
			System.out.println("1 이상의 숫자를 입력해주세요.");
		else
			for (int i = Math.min(first, second); i <= Math.max(first, second); i++)
				System.out.print(i + " ");
	}

	public void exercise5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자>> ");
		int input = sc.nextInt();
		System.out.println("=== " + input + "단 ===");
		for (int i = 1; i <= 9; i++)
			System.out.println(input + " * " + i + " = " + input * i);
	}

	public void exercise6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자>> ");
		int input = sc.nextInt();

		if (input > 9)
			System.out.println("9 이하의 양수를 입력해주세요.");
		else {
			for (int i = input; i <= 9; i++) {
				System.out.println("=== " + i + "단 ===");
				for (int j = 1; j <= 9; j++)
					System.out.println(i + " * " + j + " = " + i * j);
			}
		}
	}

	public void exercise7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력>> ");
		int input = sc.nextInt();
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < i + 1; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	public void exercise8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력>> ");
		int input = sc.nextInt();
		for (int i = input; i > 0; i--) {
			for (int j = i; j > 0; j--)
				System.out.print("*");
			System.out.println();
		}
	}
}
