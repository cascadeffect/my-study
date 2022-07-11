package com.kh.student.practice;

import java.util.Scanner;

public class StudentRun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentConsole stdConsole = new StudentConsole();
		END: while (true) {
			stdConsole.showMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				stdConsole.insertInfo();
				break;
			case 2:
				stdConsole.printInfo();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다. Good Bye~");
				break END;
			default:
				System.out.println("잘못 입력하셨습니다. 1~3 사이 숫자를 입력하세요.");
			}
		}
	}

}
