package com.kh.exceptionex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception1Exam {

	public static void main(String[] args) {
		// InputMismatchException - 정수 입력받을 때 발생하는 예외
		// ArithmeticException - 0으로 나눌 때 발생하는 예외
		// 정수 2개를 입력 받아서 나눗셈 연산 수행

		Scanner sc = new Scanner(System.in);

		while (true) {

			try {
				// 예외를 처리할 코드
				System.out.print("첫 번째 숫자 입력>> ");
				int num1 = sc.nextInt();
				System.out.print("두 번째 숫자 입력>> ");
				int num2 = sc.nextInt();

				int result = num1 / num2;
				System.out.println(num1 + "을 " + num2 + "로 나눈 몫: " + result);

			} catch (InputMismatchException e) { // multi-catch문 가능, 아래로 내려갈수록 부모 클래스여야
				// 예외 발생 시 실행하는 코드
				System.out.println("문자열은 입력할 수 없습니다. " + e.getMessage());
//				e.toString();
				sc.next(); // 오류를 발생시킨 입력 문자열을 입력받음
				continue; // while문 진행

			} catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다. " + e.getMessage());
//				continue;
			} finally {
				// 무조건 실행하는 코드
				System.out.println("finally 늘 실행되는 코드입니다.");
			}
		}
	}

}
