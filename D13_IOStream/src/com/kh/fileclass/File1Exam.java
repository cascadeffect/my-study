package com.kh.fileclass;

import java.io.File;
import java.io.IOException;

public class File1Exam {

	public static void main(String[] args) {
		/*
		 * 1. ���� ����
		 * 2. ���� ����
		 * 3. ���� ���� Ȯ��
		 * 4. ���� ���� Ȯ��
		 */
		makeFile();
		makeDirectory();
		makeDirectories();
		makeFileInDirectory();
	}

	// ���� ����
	static void makeFile() {
		File file = new File("khfile.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ���� ����
	static void makeDirectory() {
		File file = new File("C:\\kh");
		System.out.println("kh�� ������ �´°�?: " + !file.isFile()); // ���� ���� Ȯ��
		file.mkdir();
	}

	// ���� �� ���� ����
	static void makeDirectories() {
		File file = new File("C:\\kh1\\kh2\\kh3");
		System.out.println("kh3�� ������ �´°�?: " + !file.isFile()); // ���� ���� Ȯ��
		file.mkdirs();
	}

	// ���� �ȿ� ���� ����
	static void makeFileInDirectory() {
		File file = new File("C:\\kh\\khtext.txt");
		try {
			file.createNewFile();
			System.out.println("������ �����ϴ°�?: " + file.exists()); // ���� ���� Ȯ��
			System.out.println("khtext.txt�� ������ �´°�?: " + file.isFile()); // ���� ���� Ȯ��

			if (file.delete()) // ���� ����
				System.out.println("������ �����Ǿ����ϴ�.");
			System.out.println("������ �����ϴ°�?: " + file.exists());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
