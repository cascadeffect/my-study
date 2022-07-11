package com.kh.run;

import java.util.ArrayList;
import java.util.List;

public class Run {

	public static void main(String[] args) {
		List<Integer> list;

		list = new ArrayList<Integer>();
		list.add(6);
		list.add(13);
		int size = list.size();
		System.out.println("size after add(): " + size);

		list.clear();
		size = list.size();
		System.out.println("size afetr clear(): " + size);

		list.add(11);
		list.add(18);
		System.out.println("first value by get(): " + list.get(0));
		System.out.println("second value by get(): " + list.get(1));

		list.remove(0);
		list.add(0, 11);
		System.out.println("-- print by for() --");
		for (int i = 0; i < list.size(); i++)
			System.out.println(i + 1 + "'s value: " + list.get(i));

		System.out.println("null check by isEmpty(): " + !list.isEmpty());

		list.clear();
		System.out.println("null check after clear(): " + !list.isEmpty());

		// ListController lc = new ListController();
		// lc.ListExercise1();
		// lc.ListExercise2();
	}
}
