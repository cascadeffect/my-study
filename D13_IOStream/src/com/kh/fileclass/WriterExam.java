package com.kh.fileclass;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExam {

	public static void main(String[] args) {
		Writer writer = null;

		try {
			writer = new FileWriter("filewriter.txt"); // ��Ʈ���� ����
			char[] data = "�̰��� �ڹ�".toCharArray(); // ���ڿ��� ���� �迭�� ����
			for (int i = 0; i < data.length; i++)
				writer.write(data[i]); // �迭�� ���̱��� �ݺ� ����
			writer.flush(); // ��Ʈ���� ����� ���� ��
			System.out.println("���� ��"); // �ܼ� ��¿�
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
