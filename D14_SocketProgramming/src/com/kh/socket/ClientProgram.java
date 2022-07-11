package com.kh.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientProgram {

	public static void main(String[] args) {
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;

		try {
			// 2 
			System.out.println("연결 요청~~~");
			// 3 (동시)
			socket = new Socket("127.0.0.1", 4882);
			System.out.println("연결 성공!!!");

			byte[] bytes = null;
			String message = null;
			
			// 4, 데이터 전송
			os = socket.getOutputStream();
			message = "Hello Server";
			bytes = message.getBytes();
			os.write(bytes);
			os.flush();
			System.out.println("데이터 전송 완료");

			// 7, 데이터 수신
			is = socket.getInputStream();
			bytes = new byte[100];
			int readByteNo = is.read(bytes);
			message = new String(bytes, 0, readByteNo);
			System.out.println("데이터 수신 성공: " + message);

		} catch (UnknownHostException e) {
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
