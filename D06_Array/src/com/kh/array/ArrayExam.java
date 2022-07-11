package com.kh.array;

public class ArrayExam {

	public static void main(String[] args) {
		int[] kors = new int[5];
		// kors: 배열의 첫 번째 주소를 저장
		kors[0] = 10; // 주소를 통해 접근을 하되 인덱스를 사용, 0번 인덱스
		kors[1] = 20;
		kors[2] = 30;
		System.out.println("첫 번째: " + kors[0] + " 두 번째: " + kors[1] + " 세 번째: " + kors[2] + " 네 번째: " + kors[3]
				+ " 다섯 번째: " + kors[4]);
		System.out.println("배열의 크기: " + kors.length);
		System.out.println();

		int[] engs = { 50, 66, 70 }; // 할당과 초기화를 한 번에
		System.out.println("첫 번째: " + engs[0] + " 두 번째: " + engs[1] + " 세 번째: " + engs[2]);
		for (int i = 0; i < engs.length; i++)
			System.out.println(i + 1 + "번째 배열의 값: " + engs[i]);
		System.out.println();

		for (int i = 0; i < engs.length; i++)
			engs[i] = 51 + i;
		for (int i = 0; i < engs.length; i++)
			System.out.println(i + 1 + "번째 배열의 값: " + engs[i]);
	}

}