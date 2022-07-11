package com.kh.exercise;

class SubClass extends SuperClass {
	@Override
	void paint() {
		super.paint(); // SuperClass의 paint() 호출
		super.draw(); // SuperClass의 draw() 호출
	}

	@Override
	void draw() {
		System.out.println("Sub Object");
	}
}
