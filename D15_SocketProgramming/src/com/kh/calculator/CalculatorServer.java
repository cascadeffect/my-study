package com.kh.calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class CalculatorServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 8999;

		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		String formula = null;

		try {
			// connect to a  client
			serverSocket = new ServerSocket(port);
			System.out.println("연결을 기다리고 있습니다...");
			socket = serverSocket.accept();
			System.out.println("연결되었습니다.");
			
			// 주 스트림, 보조 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			
			while (true) {
				// from the client
				formula = dis.readUTF();
				// client가 bye 입력 시 종료
				if (formula.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 연결을 종료하였습니다.");
					break;
				}

				// split the formula
				StringTokenizer st = new StringTokenizer(formula, " ");
				// 잘못 입력 시 프로그램 종료
				if (st.countTokens() != 3) {
					System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
					dos.writeUTF("end");
					break;
				}
				// split된 결과를 변수에 저장
				int first = Integer.parseInt(st.nextToken());
				char opt = st.nextToken().charAt(0);
				int second = Integer.parseInt(st.nextToken());

				// calculate the formula
				String result = null;
				switch (opt) {
				case '+':
					result = String.valueOf(first + second);
					break;
				case '-':
					result = String.valueOf(first - second);
					break;
				case '*':
					result = String.valueOf(first * second);
					break;
				case '/':
					result = String.valueOf(first / second);
					break;
				case '%':
					result = String.valueOf(first % second);
					break;
				default:
					result = "error";
				}

				// to the client
				dos.writeUTF(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				dos.close();
				is.close();
				os.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
