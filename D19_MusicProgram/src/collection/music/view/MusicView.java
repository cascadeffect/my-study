package collection.music.view;

import java.util.List;
import java.util.Scanner;

import collection.music.model.vo.Music;

public class MusicView {
	// 메인 메뉴 출력
	public int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======== 메인 메뉴 ========");
		System.out.println("1. 마지막 위치에 곡 추가");
		System.out.println("2. 첫 위치에 곡 추가");
		System.out.println("3. 전체 곡 목록 출력");
		System.out.println("4. 특정 곡 검색");
		System.out.println("5. 특정 곡 삭제");
		System.out.println("6. 특정 곡 정보 수정");
		System.out.println("7. 곡명 오름차순 정렬");
		System.out.println("8. 곡명 내림차순 정렬");
		System.out.println("9. 가수명 오름차순 정렬");
		System.out.println("10. 가수명 내림차순 정렬");
		System.out.println("0. 종료");
		System.out.print(">> ");
		int input = sc.nextInt();
		return input;
	}

	// 곡 추가 == 곡 정보 입력
	public Music inputMusicInfo(String position) {
		Scanner sc = new Scanner(System.in);
		Music music = new Music();

		System.out.println("=== " + position + "에 곡 추가 ===");
		System.out.print("곡>> ");
		music.setTitle(sc.nextLine());
//		sc.nextLine();
		System.out.print("가수>> ");
		music.setSinger(sc.nextLine());
		return music;
	}

	// 전체 곡 목록 출력
	public void printMusicList(List musicList, int choice) {
		if (choice == 3)
			System.out.println("==== 전체 곡 목록 출력 ====");
		else
			System.out.println("====== 특정 곡 출력 ======");
//		System.out.println(musicList); // toString() 사용
		for (int i = 0; i < musicList.size(); i++) {
			System.out.println(i + 1 + "번째 곡 " + musicList.get(i));
		}
	}

	// 곡명 입력 => 곡 검색/수정/삭제
	public String inputMusicName(String todo) {
		Scanner sc = new Scanner(System.in);
		Music music = new Music();
		System.out.print(todo + "할 곡>> ");
		String title = sc.nextLine();
		return title;
	}

	// 특정 곡 출력
	public void printOneMusic(Music music) {
		System.out.println("======= 특정 곡 출력 =======");
		System.out.println(music);
	}

	// 특정 곡 수정 == 곡 정보 입력
	public Music modifyMusicInfo() {
		Scanner sc = new Scanner(System.in);

//		String modifiedTitle = null;
//		String modifiedSinger = null;
		Music modifiedMusic = new Music();

		System.out.println("==== 특정 곡 정보 수정 ====");
		while (true) {
			System.out.println("수정할 정보 선택");
			System.out.println("(변경이 끝나면 0번으로 저장)");
			System.out.println("1. 곡");
			System.out.println("2. 가수");
			System.out.println("0. 저장");
			System.out.print(">> ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.print("곡명>> ");
				modifiedMusic.setTitle(sc.nextLine());
				break;
			case 2:
				sc.nextLine();
				System.out.print("가수명>> ");
				modifiedMusic.setSinger(sc.nextLine());
				break;
			case 0:
				return modifiedMusic;
//				return music;
			default:
				displayError("없는 메뉴 번호");
			}
			System.out.println("--------------------------");
		}
	}

	// 서비스 성공 안내 메시지
	public void displaySuccess(String msg) {
		System.out.println("[서비스 성공] " + msg);
	}

	// 서비스 오류 안내 메시지
	public void displayError(String msg) {
		System.out.println("[서비스 실패] " + msg);
	}

	// 안내 메시지
	public void displayPrompt(String msg) {
		System.out.println(msg);
	}

}
