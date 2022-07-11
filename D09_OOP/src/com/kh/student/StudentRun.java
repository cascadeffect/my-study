package com.kh.student;

import java.util.Scanner;

public class StudentRun { // 프로그램 실행

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ManageStudent mStd = new ManageStudent();
		END: while (true) {
			mStd.showMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				mStd.insertInfo();
				break;
			case 2:
				mStd.printInfo();
				break;
			case 3:
				System.out.println("Good Bye~");
				break END;
			default:
				System.out.println("1~3 사이의 수를 입력하세요.");
			}
			System.out.println();
		}
	}

}
