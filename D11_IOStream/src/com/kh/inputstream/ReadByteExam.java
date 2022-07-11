package com.kh.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadByteExam {

	public static void main(String[] args) {
		InputStream is = null;

		try {
			is = new FileInputStream("inputStream.txt"); // new FileInputStream() => FileNotFoundException

			int readByteNo; // 새로 읽어들인 문자의 개수를 저장할 변수
			
			byte[] readByteList = new byte[3]; // 새로 읽어들인 문자를 (임시로) 저장할 배열
			String data = ""; // 배열의 문자들을 최종 문자열로 만들 때 사용할 변수

			while (true) {
				readByteNo = is.read(readByteList); // read() => IOException

				// START: value check
				for (int i = 0; i < readByteList.length; i++)
					System.out.print((char) readByteList[i]); // 배열에 저장된 문자들 출력
				System.out.println();
				System.out.println("readByteNo=" + readByteNo); // 새로 읽어들인 문자의 개수 출력
				// END: value check

				if (readByteNo == -1) // 파일에 아무것도 없으면 -1 리턴
					break;
				data += new String(readByteList, 0, readByteNo); // 새로 읽어들인 문자를 배열 인덱스 0부터
																	// readByteNo(새로 읽어들인 문자의 개수)만큼 문자열에 누적
			}
			System.out.println(data); // 최종 문자열 출력
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
