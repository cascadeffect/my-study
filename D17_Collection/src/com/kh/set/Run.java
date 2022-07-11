package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.kh.domain.Student;

public class Run {

	public static void main(String[] args) {
		// Set의 특징
		// - 저장된 값의 순서를 유지하지 않고, 중복을 허용하지 않음
		// - 순서가 없으므로 index로 접근 불가능
		// - iterator를 통해 요소에 접근 가능

		Set<String> set = new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("one");

		System.out.println("the number of data saved: " + set.size());
		set.clear();
		System.out.println("the number of data saved: " + set.size());
		set.add("1");
		set.add("2");
		System.out.println("null check: " + !set.isEmpty());

		Set<Student> stdSet = new HashSet<Student>();
		Student stdOne = new Student();
		stdOne.setName("현");
		stdOne.setScore(100);
		stdSet.add(stdOne);
		stdSet.add(new Student("고네", 99));
		stdSet.add(new Student("봉식", 20));
		stdSet.add(new Student("혜원", 1));
		stdSet.add(new Student("고네", 99)); // 객체는 set이 자동으로 중복을 제거할 수 없음
		System.out.println(stdSet.size());

		// StringTokenizer와 비슷
		Iterator<Student> it = stdSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
