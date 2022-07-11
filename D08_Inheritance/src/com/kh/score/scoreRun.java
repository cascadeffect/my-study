package com.kh.score;

import java.util.Scanner;

public class scoreRun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ScoreFunction sFunc = new ScoreFunction();
		
		END: while (true) {
			sFunc.printMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				sFunc.insertScore();
				break;
			case 2:
				sFunc.printScore();
				break;
			case 3:
				System.out.println("Good Bye~");
				break END;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

}
