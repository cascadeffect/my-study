package com.kh.array;

public class ArrayCopyExam {

	public static void main(String[] args) {
		// 얕은 복사
		int[] origin1 = {1, 2, 3, 4};
		int[] copy1 = origin1;
		copy1[0] = 5;
		System.out.println("origin1[0]: " + origin1[0] + " copy1[0]: " + copy1[0]);
		
		// 깊은 복사
		int[] origin2 = {1, 2, 3, 4};
		int[] copy2 = new int[4];
		for (int i =0; i<origin2.length;i++)
			copy2[i] = origin2[i];
		copy2[0] = 5;
		System.out.println("origin2[0]: " + origin2[0] + " copy2[0]: " + copy2[0]);
	}

}
