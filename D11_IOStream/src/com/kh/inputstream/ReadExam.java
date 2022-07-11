package com.kh.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExam {

	public static void main(String[] args) {
		InputStream is = null; // 추상클래스 특징: 1. 객체 생성 불가, 2. 참조 타입으로 사용

		try {
			is = new FileInputStream("inputStream.txt"); // checked exception => try ~ catch(FileNotFoundException e)
			int readByte;
			while (true) {
				readByte = is.read(); // checked exception => try ~ catch(FileNotFoundException e)
				if (readByte == -1) // 파일에 아무것도 없으면 -1 리턴
					break;
				System.out.println((char) readByte);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
