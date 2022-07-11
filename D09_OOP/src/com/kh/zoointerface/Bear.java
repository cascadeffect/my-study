package com.kh.zoointerface;

public class Bear extends Animal implements Predator {

	@Override
	public String animalFood() {
		return "salmon";
	}

}
