package com.kh.abstractex;

public abstract class Car { // 추상 클래스
	protected String carName;

	public abstract void move(int x); // 추상 메소드
	
//	public void move(int x) {
//		System.out.println(x + "큼 이동합니다.");
//	}

	public void stop() {
		System.out.println("멈춥니다.");
	}

}