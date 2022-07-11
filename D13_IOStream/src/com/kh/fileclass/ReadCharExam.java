package com.kh.fileclass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadCharExam {

	public static void main(String[] args) {
		Reader reader = null;

		try {
			reader = new FileReader("filereader.txt");
			int readCharNo; // ���� ������ ������ �����ϴ� ����
			char[] cbuf = new char[2]; // ���� ���ڸ� �����ϴ� �迭, ũ�� 2 == ���ڸ� 2���� �о���δ�
			String data = "";
			while ((readCharNo = reader.read(cbuf)) != -1) // read(): returns the number of characters read
				data += new String(cbuf, 0, readCharNo); // ���� �迭�� ���ڸ� ���ڿ��� ��ȯ
			// String(char[] value, int offset, int count)
			// - value: Array that is the source of characters
			// - offset: The initial offset
			// - count: The length
			System.out.println(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
