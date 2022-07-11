package com.kh.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IostreamExercise {
	static Scanner sc = new Scanner(System.in);

	static String name = null;
	static Integer age = null;
	static String addr = null;

	public static void main(String[] args) {
		// 		메뉴(menu)
		//		1. 정보입력(insert)
		//		2. 정보출력(print)
		//		3. 정보저장(save)
		//		4. 정보불러오기(load)
		//		0. 종료
		//		메뉴 입력: 1

		END: while (true) {
			menu();
			int choice = sc.nextInt();
			System.out.println();
			switch (choice) {
			case 1:
				insert();
				break;
			case 2:
				print();
				break;
			case 3:
				save();
				break;
			case 4:
				load();
				break;
			case 0:
				break END;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	static void menu() {
		System.out.println("--- 메인 메뉴 ---");
		System.out.println("1. 정보 입력");
		System.out.println("2. 정보 출력");
		System.out.println("3. 정보 저장");
		System.out.println("4. 정보 로드");
		System.out.println("0. 종료");
		System.out.print(">> ");
	}

	static void insert() {
		System.out.println("--- 정보 입력 ---");
		System.out.print("이름: ");
		name = sc.next();
		System.out.print("나이: ");
		age = sc.nextInt();
		System.out.print("주소: ");
		sc.nextLine();
		addr = sc.nextLine();
		//		info[0] = name;
		//		info[1] = String.valueOf(age);
		//		info[2] = addr;
		System.out.println();
	}

	static void print() {
		System.out.println("--- 정보 출력 ---");
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("주소: " + addr);
		System.out.println();
	}

	static void save() {
		System.out.println("--- 정보 저장 ---");
		FileWriter fWriter = null;
		//		boolean nullCheck = name == null || age == null || addr == null; // 하나라도 Null이면 true
		//		boolean emptyCheck = name.isEmpty() || addr.isEmpty(); // 하나라도 비어있으면 true
		if (name == null || age == null || addr.isEmpty()) { // addr == null || addr == "\r\n" || addr == "" || addr ==" " : 좆도 안 됨
			System.out.println("정보를 모두 입력하여야 저장이 가능합니다.");
			System.out.println();
			return;
		}
		try {
			fWriter = new FileWriter(name + ".txt");
			fWriter.write(name + "/" + age + "/" + addr);
			fWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("저장되었습니다.");
		System.out.println();
	}

	static void load() {
		System.out.println("--- 정보 로드 ---");
		System.out.println("정보를 검색할 사람의 이름을 입력하세요.");
		System.out.print(">> ");
		String search = sc.next();
		String result = null;
		File file = new File(search + ".txt");
		FileReader fReader = null;

		if (!file.isFile()) {
			System.out.println("해당 인물의 정보가 존재하지 않습니다.");
			System.out.println();
		} else
			try {
				fReader = new FileReader(search + ".txt");
				int rData;
				while ((rData = fReader.read()) != -1) {
					result += (char) rData;
					System.out.print(result);
				}
				StringTokenizer st = new StringTokenizer(result, "/");
				name = st.nextToken();
				age = Integer.parseInt(st.nextToken());
				addr = st.nextToken();
				System.out.println("정보를 로드하였습니다. 2번 메뉴를 선택하여 출력하세요.");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		System.out.println();
	}

}
