package com.kh.motel;

import java.util.Scanner;

public class Motel {
	static boolean[] rooms = new boolean[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		END: while (true) {
			printMenu();

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				printRooms();
				break;
			case 4:
				over();
				break END;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	static void printMenu() {
		System.out.println("모텔 관리 프로그램 v1.0");
		System.out.println("1. 입실 2. 퇴실 3. 방 보기 4. 종료");
		System.out.print("선택>> ");
	}

	static void checkIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 번 방에 입실하시겠습니까?");
		int roomNum = sc.nextInt();

		if (roomNum < 1 || roomNum > 10) {
			System.out.println(roomNum + "번 방은 없습니다.");
			return;
		}
		if (rooms[roomNum - 1] == true) {
			System.out.println(roomNum + "번 방에는 현재 손님이 있습니다.");
		} else {
			rooms[roomNum - 1] = true;
			System.out.println(roomNum + "번 방에 입실하셨습니다.");
		}
	}

	static void checkOut() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 번 방에서 퇴실하시겠습니까?");
		int roomNum = sc.nextInt();

		if (roomNum < 1 || roomNum > 10) {
			System.out.println(roomNum + "번 방은 없습니다.");
			return;
		}
		if (rooms[roomNum - 1] == false) {
			System.out.println(roomNum + "번 방은 현재 빈 방입니다.");
		} else {
			rooms[roomNum - 1] = false;
			System.out.println(roomNum + "번 방에서 퇴실하셨습니다.");
		}
	}

	static void printRooms() {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] == true)
				System.out.println(i + 1 + "번 방에는 현재 손님이 있습니다.");
			else
				System.out.println(i + 1 + "번 방은 현재 비어 있습니다.");
		}
	}

	static void over() {
		System.out.println("프로그램을 종료합니다.");
	}
}
