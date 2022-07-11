package com.kh.control;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		// if-else if-else
		if(num == 0) {
			System.out.println("0입니다.");
		}
		else if(num > 0) {
			System.out.println("양수입니다.");
		}
		else {
			System.out.println("음수입니다.");
		}
		// 삼항 연산자
		String result = num == 0 ? "0입니다." : (num > 0 ? "양수입니다." : "음수입니다.");
		System.out.println(result);
	}

}
