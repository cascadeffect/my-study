package com.kh.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProgram {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		InputStream is = null;
		OutputStream os = null;

		try {
			// 1
			serverSocket = new ServerSocket(4882);
			System.out.println("연결 대기...");
			// 3 (동시)
			Socket socket = serverSocket.accept();
			System.out.println("연결 수락!!!");

			byte[] bytes = null;
			String message = null;

			// 5, 데이터 수신
			is = socket.getInputStream();
			bytes = new byte[100];
			int readByteNo = is.read(bytes);
			message = new String(bytes, 0, readByteNo);
			System.out.println("데이터 수신 성공: " + message);
			
			// 6, 데이터 전송
			os = socket.getOutputStream();
			bytes = message.getBytes();
			os.write(bytes);
			os.flush();
			System.out.println("데이터 전송 완료");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
