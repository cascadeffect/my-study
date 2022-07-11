package com.kh.listcollection;

public class RList<T> {
	private Object[] objects;
	private int current;

	public RList() {
		objects = new Object[3];
		current = 0;
	}

	public void add(T input) {
		objects[current] = input;
		current++;
	}

	public T get(int index) {
		return (T) objects[index];
	}

	public int size() {
		return current;
	}

	public void clear() {
		objects = new Object[3];
		current = 0;
	}
}
