package com.kh.method;

import com.kh.exercise.MethodExercise;

public class MethodExam {

	public static void main(String[] args) {
		MethodExercise me = new MethodExercise();
		me.calcNumPrint();
		System.out.println("매개변수가 없고 반환형이 있는 메소드의 리턴 값: " + me.calcNum());
		me.calcNumPrint(500);
		System.out.println("매개변수가 있고 반환형이 있는 메소드의 리턴 값: " + me.calcNum(500));
	}

}
