package com.kh.control;

public class ForDouble1Exam {
	public static void main(String[] args) {
		for (int i = 2; i < 10; i++) {
			System.out.println("--- " + i + "단 ---");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
			if (i != 9)
				System.out.println();
		}
	}
}