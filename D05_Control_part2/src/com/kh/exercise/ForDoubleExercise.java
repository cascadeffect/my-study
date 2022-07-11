package com.kh.exercise;

public class ForDoubleExercise {
	public void exercise1() {
		for (int i = 0; i < 24; i++)
			for (int j = 0; j < 60; j++)
				System.out.println(i + "시 " + j + "분");
	}
	public void exercise2() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++)
				System.out.print(j + " * " + i + " = " + (j*i) + "\t");
			System.out.println();
		}
	}
	public void exercise3() {
		String star = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i+1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
