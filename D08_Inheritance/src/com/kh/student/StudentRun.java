package com.kh.student;

import java.util.Scanner;

public class StudentRun {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ManageStudent mStd = new ManageStudent();
		END: while (true) {
			mStd.showMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				mStd.insertInformation();
				break;
			case 2:
				mStd.printResult();
				break;
			case 3:
				System.out.println("프로그램이 종료되었습니다.");
				break END;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

}
