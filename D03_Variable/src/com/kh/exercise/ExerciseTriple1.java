package com.kh.exercise;

import java.util.Scanner;

public class ExerciseTriple1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요>> ");
		int iNum = sc.nextInt();
		String result = iNum > 0 ? "양수" : (iNum == 0 ? "0" : "음수");
		System.out.println(iNum + "은/는 " + result + "입니다.");
	}
}
