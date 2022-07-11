package com.kh.zoointerface;

public class ZooRun {

	public static void main(String[] args) {
		ZooKeeper zooKeeper = new ZooKeeper();
		zooKeeper.feed();
		Tiger tiger = new Tiger();
		zooKeeper.feed(tiger);
		Lion lion = new Lion();
		zooKeeper.feed(lion);
		Bear bear = new Bear();
		zooKeeper.feed(bear);
		Leopard leopard = new Leopard();
		zooKeeper.feed(leopard);
	}

}
