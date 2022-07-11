package com.kh.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.member.model.vo.Member;

// 화면 출력을 담당하는 클래스
public class MemberView {

	// 메뉴 출력
	public int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 회원 관리 프로그램 ======");
		System.out.println("1. 회원 정보 전체 조회");
		System.out.println("2. 회원 아이디로 조회");
		System.out.println("3. 회원 이름으로 조회");
		System.out.println("4. 회원가입");
		System.out.println("5. 회원 정보 변경");
		System.out.println("6. 회원 탈퇴");
		System.out.println("0. 프로그램 종료");
		System.out.print(">> ");
		int input = sc.nextInt();
		return input;
	}

	// 검색할 회원 아이디 입력
	public String inputMemberId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 아이디 입력>> ");
		String memberId = sc.next();
		return memberId;
	}

	// 검색할 회원 이름 입력
	public String inputMemberName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름 입력>> ");
		String memberName = sc.next();
		return memberName;
	}

	// 전체 회원 정보 출력
	public void printAllMember(List<Member> mList) {
		System.out.println("=== 전체 회원 정보 조회 결과 ===");
		for (int i = 0; i < mList.size(); i++) {
//			System.out.println(mList.get(i).toString()); // 데이터 확인용
			Member mOne = mList.get(i);
			// JSP에서 getter method 이용하여 화면 배치 후 출력할 예정
			System.out.println("아이디: " + mOne.getMemberId());
			System.out.println("이름: " + mOne.getMemberName());
			System.out.println("성별: " + mOne.getMemberGender());
			System.out.println("나이: " + mOne.getMemberAge());
			System.out.println("이메일: " + mOne.getMemberEmail());
			System.out.println("전화번호: " + mOne.getMemberPhoneNum());
			System.out.println("주소: " + mOne.getMemberAddress());
			System.out.println("취미: " + mOne.getMemberHobby());
			System.out.println("--------------------------");
		}
	}

	// 검색한 회원 정보 출력
	public void printOneMember(Member member) {
		System.out.println("===== 회원정보 조회 결과 =====");
		System.out.println("아이디: " + member.getMemberId());
		System.out.println("이름: " + member.getMemberName());
		System.out.println("성별: " + member.getMemberGender());
		System.out.println("나이: " + member.getMemberAge());
		System.out.println("이메일: " + member.getMemberEmail());
		System.out.println("전화번호: " + member.getMemberPhoneNum());
		System.out.println("주소: " + member.getMemberAddress());
		System.out.println("취미: " + member.getMemberHobby());
		System.out.println("--------------------------");
	}

	// 회원가입 시 정보 입력
	public Member inputMember() {
		Scanner sc = new Scanner(System.in);
		Member member = new Member();

		System.out.println("========== 회원가입 ==========");
		System.out.print("아이디>> ");
		member.setMemberId(sc.next());
		System.out.print("비밀번호>> ");
		member.setMemberPw(sc.next());
		System.out.print("이름>> ");
		member.setMemberName(sc.next());
		System.out.print("나이>> ");
		member.setMemberAge(sc.nextInt());
		System.out.print("성별>> ");
		member.setMemberGender(sc.next());
		System.out.print("이메일>> ");
		member.setMemberEmail(sc.next());
		System.out.print("전화번호>> ");
		member.setMemberPhoneNum(sc.next());
		sc.nextLine();
		System.out.print("주소>> ");
		member.setMemberAddress(sc.nextLine());
		System.out.print("취미>> ");
		member.setMemberHobby(sc.next());

		return member;
	}

	// 회원 정보 변경
	public Member modifyMember(Member member) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("======= 회원 정보 변경 =======");
			System.out.println("[안내] 변경할 정보를 선택해주세요.");
			System.out.println("[안내] 변경이 끝나면 0번을 눌러 저장해주세요.");
			System.out.println("1. 비밀번호");
			System.out.println("2. 이름");
			System.out.println("3. 나이");
			System.out.println("4. 이메일");
			System.out.println("5. 전화번호");
			System.out.println("6. 주소");
			System.out.println("7. 취미");
			System.out.println("0. 저장");
			System.out.print(">> ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("비밀번호>> ");
				member.setMemberPw(sc.next());
				break;
			case 2:
				System.out.print("이름>> ");
				member.setMemberName(sc.next());
				break;
			case 3:
				System.out.print("나이>> ");
				member.setMemberAge(sc.nextInt());
				break;
			case 4:
				System.out.print("이메일>> ");
				member.setMemberEmail(sc.next());
				break;
			case 5:
				System.out.print("전화번호>> ");
				member.setMemberPhoneNum(sc.next());
				break;
			case 6:
				sc.nextLine();
				System.out.print("주소>> ");
				member.setMemberAddress(sc.nextLine());
				break;
			case 7:
				System.out.print("취미>> ");
				member.setMemberHobby(sc.next());
				break;
			case 0:
				return member;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println("--------------------------");
		}
	}

	// 성공 메시지
	public void displaySuccess(String message) {
		System.out.println("[서비스 성공] " + message);
	}

	// 에러 메시지
	public void displayError(String message) {
		System.out.println("[서비스 실패] " + message);
	}
}
