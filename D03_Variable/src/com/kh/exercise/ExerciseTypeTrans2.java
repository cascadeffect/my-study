package com.kh.exercise;

import java.util.Scanner;

public class ExerciseTypeTrans2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iNum = 3;
		double dNum = 2.2;
		double result = iNum + dNum; // int->double 자동 형변환
		System.out.println(result);
		System.out.println((int)result); // double->int 강제 형변환
	}
}
