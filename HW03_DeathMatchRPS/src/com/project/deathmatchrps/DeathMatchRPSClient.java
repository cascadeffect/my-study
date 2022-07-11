package com.project.deathmatchrps;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class DeathMatchRPSClient {

	public static void main(String[] args) {
		Socket socket = null;
		String addr = "127.0.0.1";
		int port = 8881;

		Scanner sc = new Scanner(System.in);

		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		int point = 100;

		try {
			// 연결
			socket = new Socket(addr, port);
			System.out.println("서버에 연결되었습니다.");
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
				Integer[] deck = { 0, 1, 2, 3, 4, 5 };

				dos.write(point);
				int serverPoint = dis.read();

				// 데스매치 종료 조건
				if (point == 0) {
					System.out.println("포인트를 모두 잃었습니다.");
					System.out.println("데스매치에서 패배하였습니다.");
					break TURN;
				} else if (serverPoint == 0) {
					System.out.println("상대가 포인트를 모두 잃었습니다.");
					System.out.println("데스매치에서 승리하였습니다.");
					break TURN;
				}

				// 포인트 베팅
				int bet = 0;
				while (true) {
					System.out.println("10 이상의 포인트를 베팅해주세요.(보유 포인트: " + point + ")");
					System.out.print(">> ");
					bet = sc.nextInt();
					if (bet < 10) {
						System.out.println("최소 10 포인트를 베팅하여야 합니다.(보유 포인트: " + point + ")");
						continue;
					}
					if (bet > point) {
						System.out.println("포인트가 부족합니다.(보유 포인트: " + point + ")");
						continue;
					}
					if (bet > serverPoint) {
						System.out.println("상대의 포인트가 부족합니다. 다시 베팅해주세요.");
						continue;
					}
					break;
				}
				// 콜 || 다이
				int serverBet = dis.read();
				dos.write(bet);
				if (serverBet > bet) {
					System.out.println("상대(서버) 베팅: " + serverBet);
					System.out.println("상대가 더 높은 포인트를 걸었습니다. 따라가시겠습니까?");
					System.out.println("1. Call");
					System.out.println("2. Die");
					HERE: while (true) {
						System.out.print(">> ");
						int choice = sc.nextInt();
						dos.write(choice);
						switch (choice) {
						case 1:
							System.out.println(serverBet - bet + " 포인트를 더 베팅합니다.");
							bet += serverBet - bet;
							dos.write(bet);
							break HERE;
						case 2:
							point -= bet;
							System.out.println("해당 턴을 포기합니다.");
							System.out.println("-------------------");
							continue TURN;
						default:
							System.out.println("잘못 입력하셨습니다.");
							continue HERE;
						}
					}
				} else if (serverBet < bet) {
					System.out.println("상대가 " + (bet - serverBet) + " 포인트를 더 베팅하였습니다.");
					serverBet = dis.read();
					System.out.println("상대(서버) 베팅: " + serverBet);
				}
				// 턴 시작
				int score = 0;
				for (int i = 0; i < deck.length; i++) {
					// 카드 선택
					System.out.println("카드를 내주세요.(0~5)");
					System.out.print(">> ");
					int pick = sc.nextInt();
					if (pick < 0 || pick > 5) {
						System.out.println("그런 카드는 없습니다. 다시 선택해주세요.");
						i--;
						continue;
					}
					if (deck[pick] == null) {
						System.out.println("이미 낸 카드입니다. 다시 선택해주세요.");
						i--;
						continue;
					}
					deck[pick] = null;

					// 카드 공개
					int serverCard = dis.read();
					dos.write(pick);
					System.out.println("상대(서버): " + serverCard);
					System.out.println("나(클라이언트): " + pick);

					// 결과 판별
					if (pick == serverCard) {
						System.out.println("--> 비겼습니다.");
					} else if (pick > serverCard) {
						if ((pick == 2 && serverCard == 0) || (pick == 5 && serverCard == 2)) {
							System.out.println("--> 졌습니다.");
						} else {
							System.out.println("--> 이겼습니다.");
							score += pick + serverCard;
							System.out.println(pick + serverCard + " 스코어를 획득하였습니다.");
						}
					} else {
						if ((pick == 0 && serverCard == 2) || (pick == 2 && serverCard == 5)) {
							System.out.println("--> 이겼습니다.");
							score += pick + serverCard;
							System.out.println(pick + serverCard + " 스코어를 획득하였습니다.");
						} else {
							System.out.println("--> 졌습니다.");
						}
					}
					int serverScore = dis.read();
					dos.write(score);
					System.out.println("현재 스코어 [나] " + score + " : " + serverScore + " [상대]");
					if (i < 5)
						System.out.println(5 - i + "턴 남았습니다.");
				}
				// 턴 종료
				int serverScore = dis.read();
				dos.write(score);
				if (score > serverScore) {
					point += bet;
					System.out.println("--> 해당 턴을 승리하였습니다. " + bet + " 포인트를 획득하였습니다.");
				} else if (score < serverScore) {
					point -= bet;
					System.out.println("--> 해당 턴을 패배하였습니다. " + bet + " 포인트를 잃었습니다.");
				} else {
					System.out.println("--> 해당 턴은 무승부입니다. 베팅한 " + bet + " 포인트는 이동하지 않습니다.");
				}
				// 잔여 포인트 출력
				System.out.println("잔여 포인트: " + point);
				System.out.println("-------------------");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
