package com.kh.program;

import java.util.Scanner;

public class ScoreProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int kor = 0, eng = 0, math = 0;

		END: while (true) {
			System.out.println("===== 메인 메뉴 =====");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 종료");

			System.out.print("선택>> ");
			int select = sc.nextInt();
			System.out.println();

			switch (select) {
			case 1:
				System.out.println("===== 성적 입력 =====");
				System.out.print("국어>> ");
				kor = sc.nextInt();
				System.out.print("영어>> ");
				eng = sc.nextInt();
				System.out.print("수학>> ");
				math = sc.nextInt();
				break;
			case 2:
				int sum = kor + eng + math;
				double avg = (double) sum / 3;
				System.out.println("===== 성적 출력 =====");
				System.out.println("국어: " + kor);
				System.out.println("영어: " + eng);
				System.out.println("수학: " + math);
				System.out.println("총점: " + sum);
				System.out.printf("평균: %.2f", avg);
				break;
			case 3:
				System.out.println("Good Bye~");
				break END;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println();
		}
	}

}
