package com.kh.zoointerface;

public class Leopard extends Animal implements Predator {

	@Override
	public String animalFood() {
		return "gazel";
	}

}
