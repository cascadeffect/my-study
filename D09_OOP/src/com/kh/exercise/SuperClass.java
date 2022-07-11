package com.kh.exercise;

public class SuperClass {
	void paint() {
		draw(); // SubClass의 draw() 호출 == this.draw()
	}

	void draw() {
		System.out.println("Super Object");
	}
}
