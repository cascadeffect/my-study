package com.kh.scanner;

import java.util.Scanner;

public class TestScanner3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요>> ");
		String name = sc.next();
		System.out.print("태어난 달을 입력하세요>> ");
		int birthMonth = sc.nextInt();
		System.out.print("키를 입력하세요>> ");
		double height = sc.nextDouble();
		System.out.print("성별을 입력하세요(여/남)>> ");
		char sex = sc.next().charAt(0);
		System.out.print("주소를 입력하세요>> ");
		sc.nextLine(); // nextLine() 쓰기 전 필수 - 이전 입력에서 남아 있던 Enter 제거
		String address = sc.nextLine();
		
		System.out.println("이름: " + name);
		System.out.println("태어난 달: " + birthMonth);
		System.out.println("키: " + height);
		System.out.println("성별: " + sex);
		System.out.println("주소: " + address);
	}

}
