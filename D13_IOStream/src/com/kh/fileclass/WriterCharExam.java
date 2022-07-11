package com.kh.fileclass;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterCharExam {

	public static void main(String[] args) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("filewriter.txt");
			char[] data = "�̰� �ڹ�".toCharArray();
			writer.write(data);
			writer.flush();
			System.out.println("wirte(char[]) �޼ҵ� ���� ��");
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
