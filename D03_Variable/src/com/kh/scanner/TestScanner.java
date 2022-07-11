package com.kh.scanner;

import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력하세요>> ");
		int input1 = sc.nextInt();
		System.out.println("input1: " + input1);

		System.out.print("두 번정수를 입력하세요>> ");
		int input2 = sc.nextInt();
		System.out.println("input2: " + input2);
		
		int result = input1 + input2;
		System.out.println("두 값의 합은 " + result + "입니다.");
	}

}
