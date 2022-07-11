package com.kh.dimarray;

public class DimArrayExam {

	public static void main(String[] args) {
		int[][] arrs = new int[4][4];
		int k = 0;
		// 초기화
		for (int i = 0; i < arrs.length; i++)
			for (int j = 0; j < arrs[i].length; j++)
				arrs[i][j] = k++;
		// 출력
		for (int i = 0; i < arrs.length; i++) {
			for (int j = 0; j < arrs[i].length; j++)
				System.out.printf("%3d", arrs[i][j]);
			System.out.println();
		}
	}

}
