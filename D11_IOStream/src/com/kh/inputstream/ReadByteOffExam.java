package com.kh.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadByteOffExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InputStream is = null;

		try {
			is = new FileInputStream("/Users/cade/inputStream.txt");
			int readByteNo; // 새로 읽어들인 문자의 개수를 저장할 변수
			byte[] readByteList = new byte[8]; // 새로 읽어들인 문자를 최종 저장할 배열

			readByteNo = is.read(readByteList, 2, 3);
			// read(b, off, len)
			// - b: 데이터를 읽어들이는 버퍼 배열
			// - off: 배열 b에서 데이터가 기록되는 곳의 시작 인덱스
			// - len: 읽을 최대 바이트 수
			// return 버퍼 배열이 읽어들인 총 바이트 수 == 새로 읽어들인 문자의 개수
			
			for (int i = 0; i < readByteList.length; i++) {
				System.out.println((char)readByteList[i]);
				System.out.println((int)readByteList[i]);
				System.out.println(readByteList[i]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				sc.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
