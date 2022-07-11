package com.kh.array;

public class SelectionSortExam {

	public static void main(String[] args) {
		// 선택 정렬
		// { 2, 5, 4, 1, 3 } -> { 1, 2, 3, 4, 5 }
		int[] arr = { 2, 5, 4, 1, 3 };
		int minIndex = 0;
		
		System.out.print("정렬 전: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[minIndex])
					minIndex = j;
			int tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}
		
		System.out.print("\n정렬 후: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
