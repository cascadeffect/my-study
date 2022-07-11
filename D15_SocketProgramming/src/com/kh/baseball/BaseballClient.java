package com.kh.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaseballClient {

	public static void main(String[] args) {
		Socket socket = null;
		String addr = "127.0.0.1";
		int port = 8383;

		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);

		String input = null;
		String result = null;

		try {
			// connect to a server
			socket = new Socket(addr, port);
			System.out.println("클라이언트 소켓을 생성했습니다.");
			System.out.println("야구 게임 준비 완료");

			// 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);

			while (true) {
				// 사용자 입력
				System.out.print(">> ");
				input = sc.nextLine();

				// send to the server
				dos.writeUTF(input);

				// receive from the server
				result = dis.readUTF();
				System.out.println(result);
				
				// 3 strike => 종료
				if(result.contains("3 스트라이크"))
					break;
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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

}
