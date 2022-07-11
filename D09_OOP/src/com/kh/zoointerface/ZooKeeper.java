package com.kh.zoointerface;

public class ZooKeeper {
	public void feed() {
		System.out.println("feed meat to predator");
	}

	public void feed(Predator predator) {
		System.out.println("feed " + predator.animalFood());
	}

//	public void feed(Tiger tiger) {
//		System.out.println("feed beef to tiger");
//	}
//	public void feed(Lion lion) {
//		System.out.println("feed chicken to lion");
//	}
//	public void feed(Bear bear) {
//		System.out.println("feed salmon to lion");
//	}
//	public void feed(Leopard leopard) {
//		System.out.println("feed gazel to leopard");
//	}
}
