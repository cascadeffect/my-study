package com.kh.member.run;

import java.util.ArrayList;
import java.util.InputMismatchException;

import com.kh.member.controller.MemberController;
import com.kh.member.model.vo.Member;
import com.kh.member.view.MemberView;

// 실행용 클래스
public class Run {

	public static void main(String[] args) {
		MemberView mView = new MemberView();
		MemberController mController = new MemberController();
		Member member = null;

		String memberId = null;
		int index = 0;

		EXIT: while (true) {
			try {
				int choice = mView.printMenu();
				switch (choice) {
				case 1: // 회원정보 전체 조회
					ArrayList<Member> mList = mController.showAllMember();
					mView.printAllMember(mList);
					break;
				case 2: // 아이디 검색으로 회원정보 조회
					memberId = mView.inputMemberId();
					index = mController.searchMemberId(memberId);
					if (index == -1) {
						mView.displayError("회원 조회 실패");
						break;
					}
					member = mController.findOneByIndex(index);
					mView.printOneMember(member);
					break;
				case 3: // 이름 검색으로 회원정보 조회
					String memberName = mView.inputMemberName();
					index = mController.searchMemberName(memberName);
					if (index == -1) {
						mView.displayError("회원 조회 실패");
						break;
					}
					member = mController.findOneByIndex(index);
					mView.printOneMember(member);
					break;
				case 4: // 회원가입
					member = mView.inputMember();
					mController.registerMember(member);
					break;
				case 5: // 회원정보 변경
					memberId = mView.inputMemberId(); // 정보를 변경할 회원 아이디 입력
					index = mController.searchMemberId(memberId); // 회원 아이디 검색하여 인덱스 리턴
					if (index == -1) {
						mView.displayError("회원 조회 실패");
						break;
					}
					member = mController.findOneByIndex(index); // 인덱스로 회원 찾기
					/*
					 * 
					 */
					mView.modifyMember(member); // 회원 정보 변경
					mView.displaySuccess("회원 정보 변경 성공");
					break;
				case 6: // 회원 탈퇴
					memberId = mView.inputMemberId(); // 탈퇴할 회원 아이디 입력
					index = mController.searchMemberId(memberId); // 회원 아이디 검색하여 인덱스 리턴
					if (index == -1) {
						mView.displayError("회원 조회 실패");
						break;
					}
					mController.withdrawMember(index); // 인덱스를 통해 회원 탈퇴
//				mController.withdrawMember(mController.findMemberId(mView.inputMemberId()));
					break;
				case 0:
					break EXIT;
				default:
					mView.displayError("없는 메뉴 번호");
				}
			} catch (InputMismatchException e) {
				mView.displayError("문자(열) 입력");
				continue;
			}
		}
	}

}
