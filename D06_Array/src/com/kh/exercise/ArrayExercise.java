package com.kh.exercise;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayExercise {
	public void exercise1() {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.println(i + 1 + "번째 배열의 값: " + arr[i] + " ");
		}
	}

	public void exercise2() {
		String[] fruits = { "딸기", "복숭아	", "키위", "사과", "바나나" };
		for (int i = 0; i < fruits.length; i++)
			if (fruits[i].equals("바나나"))
				System.out.println(fruits[i]);
	}

	public void exercise3() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + 1 + "번째 양의 정수를 입력하세요>> ");
			arr[i] = sc.nextInt();
			if (arr[i] > max)
				max = arr[i];
		}
		System.out.println("최댓값: " + max);
	}

	public void exercise4() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + 1 + "번째 양의 정수를 입력하세요>> ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println("평균: " + (double) sum / arr.length);
	}

	public void exercise5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요(- 포함)>> ");
		String idStr = sc.next();
		char[] idArr = new char[idStr.length()];
		char[] blindId = new char[idArr.length];
		System.out.print("주민등록번호: ");
		for (int i = 0; i < idArr.length; i++) {
			idArr[i] = idStr.charAt(i);
			if (i < 8)
				blindId[i] = idArr[i];
			else
				blindId[i] = '*';
			System.out.print(blindId[i]);
		}
	}

	public void exercise6() {
		Scanner sc = new Scanner(System.in);
		int[] numArr = new int[5];

		for (int i = 0; i < numArr.length; i++) {
			System.out.print(i + 1 + "번째 양의 정수를 입력하세요>> ");
			numArr[i] = sc.nextInt();
		}

		System.out.print("정렬 전: ");
		for (int i = 0; i < numArr.length; i++)
			System.out.print(numArr[i] + " ");

		for (int i = 1; i < numArr.length; i++)
			for (int j = i; j > 0; j--)
				if (numArr[j - 1] > numArr[j]) {
					int tmp = numArr[j - 1];
					numArr[j - 1] = numArr[j];
					numArr[j] = tmp;
				}

		System.out.print("\n정렬 후: ");
		for (int i = 0; i < numArr.length; i++)
			System.out.print(numArr[i] + " ");
	}

	public void exercise7() {
		Random rand = new Random();
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rand.nextInt(45) + 1;
			if (i > 0)
				for (int j = 0; j < i; j++)
					if (lotto[j] == lotto[i]) {
						i--;
						break;
					}
		}

		for (int i = 1; i < lotto.length; i++)
			for (int j = i; j > 0; j--)
				if (lotto[j - 1] > lotto[j]) {
					int tmp = lotto[j - 1];
					lotto[j - 1] = lotto[j];
					lotto[j] = tmp;
				}

		System.out.print("로또 번호: ");
		for (int i = 0; i < lotto.length; i++)
			System.out.print(lotto[i] + " ");
	}
}
