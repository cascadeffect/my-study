package com.kh.calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CalculatorClient {

	public static void main(String[] args) {
		Socket socket = null;
		String addr = "127.0.0.1";
		int port = 8999;

		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		String formula = null;
		String result = null;

		try {
			// connect to a server
			socket = new Socket(addr, port);
			System.out.println("연결되었습니다.");
			
			// 주 스트림, 보조 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);

			while (true) {
				// to the server
				System.out.println("계산식(빈칸으로 띄어 입력. ex>> 24 + 42)");
				System.out.print(">> ");
				formula = sc.nextLine();
				dos.writeUTF(formula);
				// bye 입력 시 종료
				if (formula.equalsIgnoreCase("bye"))
					break;

				// from the server
				result = dis.readUTF();
				// 잘못 입력 시 종료
				if (result.equalsIgnoreCase("end")) {
					System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
					break;
				}
				System.out.println("계산 결과: " + result);
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
