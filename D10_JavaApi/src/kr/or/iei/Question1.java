package kr.or.iei;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numList = new int[5];

		for (int i = 0; i < numList.length; i++) {
			System.out.print(i + 1 + "번째 정수 입력 : ");
			numList[i] = sc.nextInt();
		}

		for (int i = 0; i < numList.length - 1; i++) {
			for (int j = 0; j < numList.length - 1 - i; j++) {
				if (numList[j] > numList[j + 1]) {
					int tmp = numList[j];
					numList[j] = numList[j + 1];
					numList[j + 1] = tmp;
				}
			}
		}

		System.out.print("정렬된 결과 : ");
		for (int i = 0; i < numList.length; i++) {
			System.out.print(numList[i] + " ");
		}
		System.out.println("");
		System.out.println("정렬 후 첫번째 수와 마지막수의 합 : " + (numList[0] + numList[4]));
	}
}
