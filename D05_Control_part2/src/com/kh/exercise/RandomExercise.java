package com.kh.exercise;

import java.util.Random;
import java.util.Scanner;

public class RandomExercise {
	public void exercise1() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		while (true) {
			System.out.println("===== 동전 앞뒤 맞히기 =====");
			System.out.println("1. 앞면 / 2. 뒷면");
			int coin = rand.nextInt(2) + 1; // 1~2 랜덤
			
			System.out.print("숫자를 입력해주세요>> ");
			int input = sc.nextInt();
			
			if (input != 1 && input != 2)
				System.out.println("잘못 입력하셨습니다. 1 또는 2를 입력하세요.");
			else {
				System.out.println("coin: " + coin);
				if (input == coin)
					System.out.println("맞혔습니다.");
				else
					System.out.println("틀렸습니다.");
			}
			System.out.println();
		}
	}
}
