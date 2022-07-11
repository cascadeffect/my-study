package com.kh.contorller;

import com.kh.domain.Student;
import com.kh.listcollection.IntList;
import com.kh.listcollection.ObjectList;
import com.kh.listcollection.RList;

public class ListController {

	public void ListExercise1() {
		//	int[] nums = new int[3];
		//	nums[0] = 1;
		//	nums[1] = 2;
		//	nums[2] = 3;
		//	System.out.println(nums[0]);
		//	System.out.println(nums.length);
		//	int count = 0;
		//	for (int i = 0; i < 3; i++)
		//		if (nums[i] != 0)
		//			count++;
		
		IntList list = new IntList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.get(0));
		System.out.println(list.size());
		list.clear();
	}

	public void ListExercise2() {
		ObjectList objList = new ObjectList();
		objList.add(17);
		objList.add("Collection");

		Student std = new Student();
		objList.add(std);
		//	== objList.add(new Student()); // 위 두 줄과 동일

		// ObjectList에서 값 가져오기
		int num = (int) objList.get(0);
		String str = (String) objList.get(1);
		Student stdOne = (Student) objList.get(2);
		System.out.println(num + " " + str + " " + stdOne);
		// 다양한 자료형을 사용할 수 있지만 불편한 점이 있다. ex) 형변환, ...
	}

	public void ListExercise3() {
		RList<Integer> obList = new RList<Integer>();
		obList.add(11);
		obList.add(18);
		
		int num = obList.get(0);
		num = obList.get(1);
		
		obList.add(22);
		num = obList.get(2);
		System.out.println("num: " + num);
	}
	
}
