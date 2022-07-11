package com.kh.variable;

public class TestVarExam {

	public static void main(String[] args) {
		/*
		 * 자료형별 변수를 만들고 초기화한 후 값을 출력
		 * 정수형 100, 9999억,
		 * 실수 486.520(float), 567.890123
		 * 문자 A
		 * 문자열 Hello world,
		 * 논리 true
		 */
		
		int iNum = 100;
		long lNum = 999900000000l;
		float fNum = 486.520f;
		double dNum = 5678.890123;
		char ch = 'A';
		String str = "Hello world";
		boolean bool = true;
		
		System.out.println("정수(int): " + iNum);
		System.out.println("정수(long): " + lNum);
		System.out.println("실수(float): " + fNum);
		System.out.println("실수(double): " + dNum);
		System.out.println("문자(char): " + ch);
		System.out.println("문자열(String): " + str);
		System.out.println("논리(boolean): " + bool);
		
		System.out.println(1 + 1); // 2
		System.out.println(1.1 + 1.1); // 2.2
		System.out.println('1'+'1'); // 98
		System.out.println("1" + "1"); // 11
		
		System.out.println("Hello" + 'q'); // Helloq
		System.out.println("Hello" + 10); // Hello10
		System.out.println("Hello" + 3.14); // Hello3.14
		System.out.println(10+"Hello"); // 10Hello
		System.out.println(10+20+"Hello"); // 30Hello
		System.out.println(10+(20+"Hello")); // 1020Hello
		System.out.println(10+"Hello"+20); // 10Hello20
	}

}