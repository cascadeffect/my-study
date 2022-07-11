package com.kh.array;

public class InsertionSortExam {

	public static void main(String[] args) {
		// 삽입 정렬
		// { 2, 5, 4, 1, 3 } -> { 1, 2, 3, 4, 5 }
		int[] arr = { 2, 5, 4, 1, 3 };
		
		System.out.print("정렬 전: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		for (int i = 1; i < arr.length; i++)
			for (int j = i; j > 0; j--)
				if (arr[j - 1] > arr[j]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
		System.out.print("\n정렬 후: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
