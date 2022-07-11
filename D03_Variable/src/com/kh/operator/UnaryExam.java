package com.kh.operator;

public class UnaryExam {
	public static void main(String[] args) {

		// #1
		System.out.println("----------#1----------");
		int a = 10;
		int b = 20;
		int c = 30;

		a++; // a = 11
		b = (--a) + b; // a = 10 -> b = 10 + 20 = 30
		c = (a++) + (--b); // b = 29 -> c = 10 + 29 = 39 -> a = 11
		// 후위 연산자는 괄호를 쳐도 연산이 끝난 후 증가

		System.out.println("a: " + a); // 11
		System.out.println("b: " + b); // 29
		System.out.println("c: " + c); // 39
		System.out.println();

		// #2
		System.out.println("----------#2----------");
		boolean flag = true;

		System.out.println(!!!!flag); // true
		System.out.println();

		// #3
		System.out.println("----------#3----------");
		int x = 100;
		int y = 33;
		int z = 0;

		x--;// x = 99
		z = x-- + --y; // y = 32 -> z = 99 + 32 = 131 -> x = 98
		x = 99 + x++ + x; // x = 99 + 98 + 99 = 296
		y = y-- + y + ++y; // y = 32 + 31 + 32 = 95
		// 같은 변수를 만났을 때 후위 연산

		System.out.println("x: " + x); // 296
		System.out.println("y: " + y); // 95
		System.out.println("z: " + z); // 131
	}
}
