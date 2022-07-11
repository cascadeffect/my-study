package com.kh.exercise;

public class SuperSubExam {

	public static void main(String[] args) {
		// 동적 바인딩: 상속 관계로 이루어져 다형성이 적용된 경우,
		// 메소드 오버라이딩이 되어 있으면 정적으로 바인딩 된 메소드 코드보다
		// 오버라이딩 된 메소드 코드를 우선적으로 수행

		SuperClass ex = new SubClass();
		// SubClass의 주소를 갖고 있는 SuperClass 타입의 객체 ex

		ex.paint();
		// 1. ex.paint(): Overriding 된 SubClass의 paint() 실행
		// 2. super.paint(): SuperClass의 paint() 실행
		// 3. draw(): 동적 바인딩에 의해 SubClass의 draw() 실행
		// 4. "Sub Object" 출력
		// 5. super.draw(): SuperClass의 draw() 실행
		// 6. "Super Object" 출력
	}

}
