package com.kh.exercise;

import java.util.Scanner;

public class SwitchExercise {
	public void exercise1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요(1~3)>> ");
		int select = sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("빨간색입니다.");
			break;
		case 2:
			System.out.println("파란색입니다.");
			break;
		case 3:
			System.out.println("초록색입니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	public void exercise2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수를 입력하세요>> ");
		int a = sc.nextInt();
		System.out.print("두 번째 수를 입력하세요>> ");
		int b = sc.nextInt();
		System.out.print("연산자를 입력하세요(+,-,*,/)>> ");
		char opt = sc.next().charAt(0);

		int result = 0;
		switch (opt) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		case '/':
			result = a / b;
			break;
		default:
			System.out.println("연산자를 잘못 입력하셨습니다.");
		}
		System.out.println("" + a + opt + b + " = " + result);
	}

	public void exercise3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요(1~12월)>> ");
		int month = sc.nextInt();
		int lastDay = 0;

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			lastDay = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDay = 30;
			break;
		case 2:
			lastDay = 28;
			break;
		default:
			System.out.println("1~12 사이의 숫자를 입력하세요.");
		}
		System.out.println(month + "월은 " + lastDay + "일까지입니다.");
	}
}
