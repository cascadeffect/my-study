package com.kh.polymorphism;

public class PolyExam {
	public static void main(String[] args) {
		// Up-casting
		Car car = new Sonata();
		car.move(10);
		car.stop();
//		car.moveSonata(); // Error
		// Down-casting
		((Sonata) car).moveSonata();

		Car[] cars = new Car[5];
		cars[0] = new Sonata(); // Up-casting
		cars[1] = new Car();
		cars[2] = new Car();
		cars[3] = new Car();
		cars[4] = new Car();

		Sonata[] sonatas = new Sonata[3];
		sonatas[0] = new Sonata();
		sonatas[1] = new Sonata();
		sonatas[2] = new Sonata();
	}
}
