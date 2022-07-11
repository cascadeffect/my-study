package com.kh.fileclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class ReamExam {

	public static void main(String[] args) {
		// �� �� �߻� Ŭ������ ��ü ���� X => ������
		InputStream is = null; // ����Ʈ ��� ��Ʈ���� ���� Ŭ����
		Reader reader = null; // ���� ��� ��Ʈ���� �ֻ��� Ŭ����

		try {
			reader = new FileReader("filereader.txt");
			int readData;
			while ((readData = reader.read()) != -1)
				System.out.print((char) readData);
			
			System.out.println();
			
			is = new FileInputStream("filereader.txt");
			int streamData;
			while((streamData = is.read()) != -1)
				System.out.print((char) streamData);
			
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
