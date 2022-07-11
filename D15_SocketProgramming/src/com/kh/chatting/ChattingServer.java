package com.kh.chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChattingServer {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 8181;

		InputStream is = null; // 입력 주 스트림
		OutputStream os = null; // 출력 주 스트림
		DataInputStream dis = null; // 입력 보조 스트림
		DataOutputStream dos = null; // 출력 보조 스트림
		Scanner sc = new Scanner(System.in);

		String sendMsg = null;
		String recvMsg = null;
		String serverName = "서버(나): ";
		String clientName = "클라이언트(상대): ";

		try {
			System.out.println("채팅 서버를 구동 중입니다...");
			Thread.sleep(1000);
			serverSocket = new ServerSocket(port);
			System.out.println("채팅 서버를 구동하였습니다.");
			Thread.sleep(1000);
			System.out.println("클라이언트의 접속을 기다리는 중입니다.");
			socket = serverSocket.accept();
			System.out.println("클라이언트가 접속하였습니다.");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			// 보조 스트림은 객체를 생성할 때 매개변수로 주 스트림을 사용
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("채팅이 시작됩니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true)
			try {
				System.out.print(serverName);
				sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg); // 보조 스트림의 역할: 기능 추가 => byte 배열 불필요
				if (sendMsg.equals("exit")) {
					System.out.println("채팅을 종료합니다.");
					break;
				}
				//////////////////////////////////////////
				recvMsg = dis.readUTF();
				if (recvMsg.equals("exit")) {
					System.out.println(clientName + "채팅방을 나갔습니다.");
					break;
				}
				System.out.println(clientName + recvMsg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		// 자원 해제
		try {
			dis.close();
			dos.close();
			is.close();
			os.close();
			serverSocket.close();
			socket.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
