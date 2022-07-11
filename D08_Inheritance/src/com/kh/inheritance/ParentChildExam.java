package com.kh.inheritance;

import com.kh.exercise.Child;

public class ParentChildExam {
	public static void main(String[] args) {
		Child child = new Child();
//		System.out.println("Parent's money: " + child.money);
		System.out.println("Parent's money: " + child.getMoney());
		child.setMonen(200);
		System.out.println("Parent's money: " + child.getMoney());
		child.pizzaRecipe();
		child.printInfo();
	}
}
