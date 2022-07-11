package com.project.deathmatchrps;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

public class DeathMatchRPSServer {

	public static void main(String[] args) throws SocketException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 8881;

		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		Random rand = new Random();

		int point = 100;

		try {
			// 연결
			serverSocket = new ServerSocket(port);
			System.out.println("클라이언트를 기다리는 중...");
			socket = serverSocket.accept();
			System.out.println("클라이언트가 접속하였습니다.");
			Thread.sleep(500);
			System.out.println("=== 게임명: 카드 가위바위보 ===");
			Thread.sleep(500);
			// 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);

			// 데스매치 시작
			System.out.println("데스매치를 시작합니다.");
			Thread.sleep(500);
			TURN: while (true) {
				// 0~5 카드 덱 생성
				int[] deck = new int[6];
				for (int i = 0; i < deck.length; i++) {
					deck[i] = rand.nextInt(6);
					for (int j = 0; j < i; j++) {
						if (deck[i] == deck[j]) {
							i--;
							break;
						}
					}
				}

				int clientPoint = dis.read();
				dos.write(point);

				// 데스매치 종료 조건
				if (point == 0) {
					System.out.println("포인트를 모두 잃었습니다.");
					System.out.println("데스매치에서 패배하였습니다.");
					break TURN;
				} else if (clientPoint == 0) {
					System.out.println("상대가 포인트를 모두 잃었습니다.");
					System.out.println("데스매치에서 승리하였습니다.");
					break TURN;
				}

				// 포인트 베팅
				int bet = 0;
				System.out.println("포인트를 베팅합니다.(보유 포인트: " + point + ")");
				do {
					bet = ((rand.nextInt(10) + 1) * 10);
				} while (bet > point || bet > clientPoint);
				System.out.println(">> " + bet);

				// 콜 || 다이
				dos.write(bet);
				int clientBet = dis.read();
				if (clientBet > bet) {
					System.out.println("상대(클라이언트) 베팅: " + clientBet);
					System.out.println(clientBet - bet + " 포인트를 더 베팅합니다.");
					bet += clientBet - bet;
					dos.write(bet);
				} else if (clientBet < bet) {
					HERE: while (true) {
						int clientChoice = dis.read();
						switch (clientChoice) {
						case 1:
							System.out.println("상대가 " + (bet - clientBet) + " 포인트를 더 베팅하였습니다.");
							clientBet = dis.read();
							System.out.println("상대(클라이언트) 베팅: " + clientBet);
							break HERE;
						case 2:
							System.out.println("클라이언트가 베팅을 포기하였습니다. 해당 턴을 승리하였습니다.");
							point += clientBet;
							System.out.println(clientBet + " 포인트를 획득하였습니다.");
							continue TURN;
						}
					}
				}

				// 턴 시작
				int score = 0;
				for (int i = 0; i < deck.length; i++) {
					System.out.println("카드를 내주세요.(0~5)");
					System.out.println(">> " + deck[i]);

					// 카드 공개
					dos.write(deck[i]);
					int clientCard = dis.read();
					System.out.println("상대(클라이언트): " + clientCard);
					System.out.println("나(서버): " + deck[i]);

					// 결과 판별
					if (deck[i] == clientCard) {
						System.out.println("--> 비겼습니다.");
					} else if (deck[i] > clientCard) {
						if ((deck[i] == 2 && clientCard == 0) || (deck[i] == 5 && clientCard == 2)) {
							System.out.println("--> 졌습니다.");
						} else {
							System.out.println("--> 이겼습니다.");
							score += deck[i] + clientCard;
							System.out.println(deck[i] + clientCard + " 스코어를 획득하였습니다.");
						}
					} else {
						if ((deck[i] == 0 && clientCard == 2) || deck[i] == 2 && clientCard == 5) {
							System.out.println("--> 이겼습니다.");
							score += deck[i] + clientCard;
							System.out.println(deck[i] + clientCard + " 스코어를 획득하였습니다.");
						} else {
							System.out.println("--> 졌습니다.");
						}
					}
					dos.write(score);
					int clientScore = dis.read();
					System.out.println("현재 스코어 [나] " + score + " : " + clientScore + " [상대]");
					if (i < 5)
						System.out.println(5 - i + "턴 남았습니다.");
				}
				// 턴 종료
				dos.write(score);
				int clientScore = dis.read();
				if (score > clientScore) {
					point += bet;
					System.out.println("--> 해당 턴을 승리하였습니다. " + bet + " 포인트를 획득하였습니다.");
				} else if (score < clientScore) {
					point -= bet;
					System.out.println("--> 해당 턴을 패배하였습니다. " + bet + " 포인트를 잃었습니다.");
				} else {
					System.out.println("--> 해당 턴은 무승부입니다. 베팅한 " + bet + " 포인트는 이동하지 않습니다.");
				}
				// 잔여 포인트 출력
				System.out.println("잔여 포인트: " + point);
				System.out.println("-------------------");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
				dis.close();
				dos.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
