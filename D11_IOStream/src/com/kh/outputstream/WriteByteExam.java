package com.kh.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteByteExam {

	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("outputStream.txt");
			byte[] data = "Real I/O".getBytes();
			os.write(data);
			os.flush();
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
