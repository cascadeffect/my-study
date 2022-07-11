package com.kh.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChattingServer {

	public static void main(String[] args) {
//		채팅 서버를 구동 중입니다...
//		채팅 서버 구동이 완료되었습니다.
//		클라이언트의 접속을 기다리고 있습니다.
//		클라이언트가 접속하였습니다.
//		채팅이 시작되었습니다.
//		서버(나): 이상형이 뭐야?
//		클라이언트(고네): 두 손 놓고 오토바이 타는 남자

		ServerSocket serverSocket = null;
		int port = 8282;

		InputStream is = null;
		OutputStream os = null;
		Scanner sc = new Scanner(System.in);
		String sendMsg = null;
		String recvMsg = null;
		String serverName = "서버(나): ";
		String clientName = "클라이언트(상대): ";

		try {
			System.out.println("채팅 서버를 구동 중입니다...");
			Thread.sleep(2000); // 시간 지연 2초 = 1/1000 * ?
			serverSocket = new ServerSocket(port);
			System.out.println("채팅 서버를 구동하였습니다.");
			Thread.sleep(2000); // 시간 지연 2초
			System.out.println("클라이언트의 접속을 기다리고 있습니다.");
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트가 접속하였습니다.");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			System.out.println("채팅이 시작되었습니다.");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				// 데이터 전송
				System.out.print(serverName);
				sendMsg = sc.nextLine();
				byte[] bytes = sendMsg.getBytes();
				os.write(bytes);
				os.flush();

				// 데이터 수신
				bytes = new byte[100];
				int recvByteNo = is.read(bytes);
				recvMsg = new String(bytes, 0, recvByteNo);
				System.out.println(clientName + recvMsg);

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
