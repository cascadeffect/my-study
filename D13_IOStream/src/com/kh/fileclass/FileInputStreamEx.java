package com.kh.fileclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamEx {
	public static void main(String[] args) {

		InputStream is = null;

		try {
			is = new FileInputStream("C:\\workspace\\D13_IOStream\\src\\com\\kh\\exercise\\FileInputStreamEx.java");
			int dataByteNo;
			byte[] buff = new byte[100];
			String result = "";
			while ((dataByteNo = is.read(buff)) != -1)
				result += new String(buff, 0, dataByteNo);
			System.out.println(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
