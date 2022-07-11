package com.kh.exercise;

import com.kh.inheritance.Parent;

public class Child extends Parent {
	int myMoney = 1000;
	int money = 3000;
	
	public Child() {
		super();
	}
	
	public void printInfo() {
		System.out.println("Child's money: " + this.money);
		System.out.println("Child's myMoney: " + this.myMoney);
		System.out.println("Parent's money: " + super.money);
	}
	@Override
	public void pizzaRecipe() {
		System.out.println("도우는 두껍게, 햄은 많이");
	}
}
