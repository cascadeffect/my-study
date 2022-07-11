package com.kh.fileclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyExam {

	public static void main(String[] args) {
		// �̹��� ���� ����

		InputStream is = null;
		OutputStream os = null;

		try {
			// �̹��� ���ϵ� ������ ������ ���̳ʸ� �ڵ�(���� ������)�� �Ǿ� �ֱ� ������
			// �ش� ������ ����Ʈ �迭�� �а� ���� �Ǹ� ���� ����
			is = new FileInputStream("C:\\tmp\\sk8er.png");
			os = new FileOutputStream("C:\\Users\\82107\\Desktop\\copied.png");
			
			int readByteNo;
			byte[] readBytes = new byte[100];
			
			while ((readByteNo = is.read(readBytes)) != -1) {
				os.write(readBytes, 0, readByteNo);
			}
			os.flush();
			System.out.println("���簡 �Ϸ�Ǿ����ϴ�.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
