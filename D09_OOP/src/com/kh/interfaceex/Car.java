package com.kh.interfaceex;

public interface Car {
//	 추상 클래스의 변형체
//	 추상 클래스는 일반 변수, 메소드도 선언 가능하지만,
//	 인터페이스는 상수형 필드, 추상 메소드만 선언 가능
//	 public void carName; (X)
//	 public void stop() { System.out.println("멈춥니다."); } (X)
	
	String carName = "BMW"; // 앞에 [public static final] 생략된 상수
	void move(int x); // 추상 메소드
	void stop(); // 추상 메소드
}
