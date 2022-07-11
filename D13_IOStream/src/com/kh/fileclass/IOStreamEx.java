package com.kh.fileclass;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class IOStreamEx {

	public static void main(String[] args) {
		/*
		 * ���� 1. ���ϸ� �Է�: khtext.txt
		 * ���� 2. ���Ͽ� ������ ���� �Է�:
		 * 1>> 1111
		 * 2>> text input
		 * 3>> good
		 * 4>> gogogo
		 * 5>> exit
		 * ���� 3. ����: exit
		 * ���� 4. exit �����ϰ� ���Ͽ� ����
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("���ϸ��� �Է��ϼ���.");
		String fileName = sc.next();
		sc.nextLine();

		Writer writer = null;
		int lineNum = 1;

		try {
			writer = new FileWriter(fileName);
			System.out.println(fileName + " ���Ͽ� ����� ������ �Է��ϼ���.");
			while (true) {
				System.out.print(lineNum++ + ">> ");
				String input = sc.nextLine();
				if (input.equals("exit"))
					break;
				writer.write(input + "\n");
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
