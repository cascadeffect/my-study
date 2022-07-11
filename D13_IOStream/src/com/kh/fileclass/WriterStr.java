package com.kh.fileclass;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterStr {

	public static void main(String[] args) {
		Writer writer = null;

		try {
			writer = new FileWriter("filewriter.txt");
			String data = "�ڹٰ� ������ �� �˾��ݴ�";
			writer.write(data);
			writer.flush();
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
