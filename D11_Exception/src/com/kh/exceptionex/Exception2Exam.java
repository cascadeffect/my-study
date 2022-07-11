package com.kh.exceptionex;

public class Exception2Exam {

	public static void main(String[] args) {
		// ArrayIndexOutOfBoundsException - 인덱스 범위 예외
		try {
			int[] arr = new int[3];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			System.out.println(arr[3]); // ArrayIndexOutOfBoundsException
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위가 넘어갔습니다.");
		}
	}

}
