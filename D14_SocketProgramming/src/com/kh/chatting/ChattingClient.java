package com.kh.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient {

	public static void main(String[] args) {
//		서버에 연결 중입니다.
//		채팅 서버에 접속하였습니다.
//		서버와의 채팅을 시작합니다.
//		서버(현): 이상형이 뭐야?
//		클라이언트(나): 두 손 놓고 오토바이 타는 남자

		Socket socket = null;
		int port = 8282;
		String addr = "127.0.0.1";

		InputStream is = null;
		OutputStream os = null;
		Scanner sc = new Scanner(System.in);
		String sendMsg = null;
		String recvMsg = null;
		String serverName = "서버(상대): ";
		String clientName = "클라이언트(나): ";

		try {
			System.out.println("서버에 연결 중입니다.");
			socket = new Socket(addr, port);
			System.out.println("채팅 서버에 접속하였습니다");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			System.out.println("서버와의 채팅을 시작합니다.");

		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				// 데이터 수신
				byte[] bytes = new byte[100];
				int readByteNo = is.read(bytes);
				recvMsg = new String(bytes, 0, readByteNo);
				System.out.println(serverName + recvMsg);

				// 데이터 전송
				System.out.print(clientName);
				sendMsg = sc.nextLine();
				bytes = sendMsg.getBytes();
				os.write(bytes);
				os.flush();

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

}
