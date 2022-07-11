package com.kh.zoointerface;

public class Lion extends Animal implements Predator {

	@Override
	public String animalFood() {
		return "chicken";
	}

}
