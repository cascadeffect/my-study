package com.kh.listcollection;

public class ObjectList {
	private Object[] objects;
	private int current;

	public ObjectList() {
		objects = new Object[3];
		current = 0;
	}

	public void add(Object input) {
		objects[current] = input;
		current++;
	}

	public Object get(int index) {
		return objects[index];
	}

	public Object size() {
		return current;
	}

	public void clear() {
		objects = new Object[3];
		current = 0;
	}
}
