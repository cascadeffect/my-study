package com.kh.exercise;

import java.util.Scanner;

public class ExerciseTriple2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수 입력>> ");
		int a = sc.nextInt();
		System.out.print("두 번째 수 입력>> ");
		int b = sc.nextInt();
		System.out.print("연산자 입력(+/-)>> ");
		char opt = sc.next().charAt(0);
		String result = opt == '+' ? "결과: " + (a+b) : (opt == '-' ? "결과: " + (a-b) : "잘못 입력하셨습니다.");
		System.out.println(result);
	}
}
