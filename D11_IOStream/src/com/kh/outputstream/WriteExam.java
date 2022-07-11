package com.kh.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExam {

	public static void main(String[] args) {
		OutputStream os = null;

		try {
			os = new FileOutputStream("outputStream.txt"); // 1. 스트림을 연다.
			byte[] data = "Hello I/O".getBytes(); // 2. 문자열을 바이트 배열에 한 글자씩 저장한다.
			for (int i = 0; i < data.length; i++) {
				os.write(data[i]); // 3. 바이트 배열의 데이터를 한 글자씩 파일에 쓴다.
			}
			os.flush(); // 4. 스트림을 비워서 쓰기를 완료한다.
			System.out.println("파일 쓰기 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
