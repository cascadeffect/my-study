package com.kh.array;

public class ArraySortExam {

	public static void main(String[] args) {
		int[] numArr = { 2, 1, 3 }; // -> 1 3 2
		int tmp = numArr[0];
		numArr[0] = numArr[1];
		numArr[1] = numArr[2];
		numArr[2] = tmp;
		for(int i = 0; i < numArr.length; i++)
			System.out.print(numArr[i] + " ");
	}

}
