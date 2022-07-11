package com.kh.exercise;

import java.util.Scanner;

public class ExerciseTypeTrans1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요>> ");
		int input = sc.nextInt();
		System.out.println("문자로 변환: " + (char)input);
	}
}
