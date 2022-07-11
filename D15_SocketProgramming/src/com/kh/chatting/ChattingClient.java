package com.kh.chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChattingClient {

	public static void main(String[] args) {
		Socket socket = null;
		String addr = "127.0.0.1";
		int port = 8181;

		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);

		String sendMsg = null;
		String recvMsg = null;
		String serverName = "서버(상대): ";
		String clientName = "클라이언트(나): ";

		try {
			System.out.println("서버에 연결 중입니다.");
			socket = new Socket(addr, port);
			System.out.println("채팅 서버에 접속하였습니다.");
			// 아래 두 줄 == 채팅 프로그램의 특징: 입력과 출력이 모두 있다
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("서버와의 채팅을 시작합니다.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (true)
			try {
				recvMsg = dis.readUTF();
				if (recvMsg.equals("exit")) {
					System.out.println(serverName + "채팅방을 나갔습니다.");
					break;
				}
				System.out.println(serverName + recvMsg);
				//////////////////////////////////////////
				System.out.print(clientName);
				sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg);
				if (sendMsg.equals("exit")) {
					System.out.println("채팅을 종료합니다.");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		// 자원 해제
		try {
			dis.close();
			dos.close();
			is.close();
			os.close();
			socket.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
