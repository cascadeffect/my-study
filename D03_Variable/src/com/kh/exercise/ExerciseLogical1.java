package com.kh.exercise;

import java.util.Scanner;

public class ExerciseLogical1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요>> ");
		int iNum = sc.nextInt();
		boolean result = iNum >= 1 && iNum <= 100 ? true : false;
		System.out.println("1부터 100 사이의 숫자인가? " + result);
	}

}
