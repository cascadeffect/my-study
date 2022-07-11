package com.kh.run;

import com.kh.oop.Person;
import com.kh.oop.Suit;

public class Run {

	public static void main(String[] args) {

		Person person = new Person();
		person.setName("최현지");
		System.out.println(person.getName());
		person.setAddress("서울시 서대문구");
		System.out.println(person.getAddress());

		Suit s = new Suit(100);
	}

}
