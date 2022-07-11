package com.kh.operator;

public class LogicalExam {

	public static void main(String[] args) {
		System.out.println("논리 연산자 예제");
		System.out.println();
		
		System.out.println("----------#1----------");
		int a = 50;
		int b = 30;
		
		System.out.println("a<b || a==b " + (a<b || a==b));
		System.out.println("a>b && a!=b " + (a>b && a!=b));
		System.out.println("a>b || a==b " + (a>b || a==b));

		System.out.println();
		System.out.println("----------#2----------");
		a = 70;
		b = 55;
		
		System.out.println(a==b || a++<100); // false || true = true, a = 71
		System.out.println(a<b && --b<55); // false, 뒤의 연산 동작 X
		System.out.println(a!=b && b--<a++); // true && true = true, b = 54, a = 72
		System.out.println(a++!=b || b++>=85); // true, a = 73, 뒤의 연산 동작 X
		System.out.println("a: " + a); // 73
		System.out.println("b: " + b); // 54
		
	}

}
