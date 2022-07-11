package com.kh.fileclass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadCharOffExam {

	public static void main(String[] args) {
		Reader reader = null;

		try {
			reader = new FileReader("filereader.txt");
			int readCharNo;
			char[] cbuf = new char[4];
			readCharNo = reader.read(cbuf, 0, 4);
			for(int i = 0; i < cbuf.length; i++)
				System.out.println(cbuf[i]);

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
