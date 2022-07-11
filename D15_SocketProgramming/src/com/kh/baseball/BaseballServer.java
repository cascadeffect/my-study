package com.kh.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.StringTokenizer;

public class BaseballServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 8383;

		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		String serverNum = "";
		String input = null;
		String result = null;

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("서버 소켓을 생성하였습니다.");
			Thread.sleep(1000);
			System.out.println("클라이언트의 접속을 기다립니다...");
			socket = serverSocket.accept();
			System.out.println("클라이언트가 접속했습니다.");

			// 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);

			// server numbers array 생성
			Random rand = new Random();
			int[] numbers = new int[3];
			for (int i = 0; i < 3; i++) {
				numbers[i] = rand.nextInt(9) + 1;
				// 중복 제거
				for (int j = 0; j < i; j++) {
					if (numbers[i] == numbers[j]) {
						i--;
						break;
					}
				}
			}
			// server numbers array(numbers) to string(serverNum)
			for (int i = 0; i < numbers.length; i++) {
				serverNum += String.valueOf(numbers[i] + " ");
			}
			System.out.println("서버 숫자: " + serverNum); // 서버 숫자 출력
			System.out.println("서버 준비 완료");

			// split the serverNum
			StringTokenizer stServer = new StringTokenizer(serverNum, " ");

			// baseball game start
			while (true) {
				// receive from the client
				input = dis.readUTF();
				StringTokenizer stClient = new StringTokenizer(input, " ");
//				for(int i = 0; stClient.hasMoreElements(); i++) {}
				int firstInput = Integer.parseInt(stClient.nextToken());
				int secondInput = Integer.parseInt(stClient.nextToken());
				int thirdInput = Integer.parseInt(stClient.nextToken());
				System.out.println("클라이언트가 입력한 수: " + firstInput + " " + secondInput + " " + thirdInput);

				// strike or ball 판별
				int strike = 0;
				int ball = 0;
				if (serverNum.contains(String.valueOf(firstInput))) {
					if (firstInput == numbers[0]) {
						strike++;
					} else
						ball++;
				}

				if (serverNum.contains(String.valueOf(secondInput))) {
					if (secondInput == numbers[1]) {
						strike++;
					} else
						ball++;
				}

				if (serverNum.contains(String.valueOf(thirdInput))) {
					if (thirdInput == numbers[2]) {
						strike++;
					} else
						ball++;
				}
				result = strike + " 스트라이크 " + ball + " 볼";

				// send to the client
				dos.writeUTF(result);

				// 3 strike => 종료
				if (strike == 3)
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
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
