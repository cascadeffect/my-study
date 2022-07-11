package com.kh.inheritance;

public class Parent {
	// public: 다른 패키지까지
	// protected: 상속 클래스까지
	// default: 같은 패키지 내
	// private: 같은 클래스 내
	protected int money = 2000;

	public int getMoney() {
		return money;
	}

	public void setMonen(int money) {
		this.money += money;
	}

	public void pizzaRecipe() {
		System.out.println("도우는 얇게, 치즈는 많이");
	}

}
