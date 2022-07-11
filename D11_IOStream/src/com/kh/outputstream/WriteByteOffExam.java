package com.kh.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteByteOffExam {

	public static void main(String[] args) {
		OutputStream os = null;

		try {
			os = new FileOutputStream("/Users/cade/outputStream.txt");
			byte[] data = "ABCDE".getBytes();
			os.write(data, 2, 2);
			// write(b, off, len)
			// - b: the data
			// - off: the start offset in the data
			// - len: the number of bytes to write
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
