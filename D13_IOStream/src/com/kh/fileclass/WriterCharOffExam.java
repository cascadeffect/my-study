package com.kh.fileclass;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterCharOffExam {

	public static void main(String[] args) {
		Writer writer = null;

		try {
			writer = new FileWriter("filewriter.txt");
			char[] cbuf = "���޿�".toCharArray();
			writer.write(cbuf, 0, 2);
			// write(cbuf, off, len)
			// - cbuf: Array of characters
			// - off: Offset from which to start writing characters
			// - len: Number of characters to write
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
