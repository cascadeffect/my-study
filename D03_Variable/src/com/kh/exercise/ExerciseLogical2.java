package com.kh.exercise;

import java.util.Scanner;

public class ExerciseLogical2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 하나 입력하세요>> ");
		char ch = sc.next().charAt(0);
		boolean result = ch >= 'A' && ch <= 'Z' ? true : false;
		System.out.println("대문자인가? " + result);
	}

}
