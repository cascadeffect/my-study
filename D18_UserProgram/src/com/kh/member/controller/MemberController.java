package com.kh.member.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.member.model.vo.Member;

// 데이터 추가, 수정, 삭제를 담당하는 클래스
public class MemberController {
	private ArrayList<Member> mList; // 멤버 객체를 저장할 최종 저장소

	// 생성자: 초기화
	public MemberController() {
		mList = new ArrayList<Member>();
	}

	// 회원정보 전체 조회
	public ArrayList<Member> showAllMember() {
		return mList;
	}

	// 회원 아이디 찾기 -> 인덱스 리턴
	public int searchMemberId(String memberId) {
		for (int i = 0; i < mList.size(); i++) {
			Member mOne = mList.get(i);
			if (memberId.equals(mOne.getMemberId())) {
				return i;
			}
		}
		return -1;
	}

	// 회원 이름 찾기 -> 인덱스 리턴
	public int searchMemberName(String memberName) {
		for (int i = 0; i < mList.size(); i++) {
			Member mOne = mList.get(i);
			if (memberName.equals(mOne.getMemberName())) {
				return i;
			}
		}
		return -1;
	}

	// 인덱스로 회원 검색
	public Member findOneByIndex(int index) {
		Member member = mList.get(index);
		return member;
	}

//	// findMemberId + withdrawMember
//	public void wirthdrawMemberById(String memberId) {
//		for (int i = 0; i < mList.size(); i++) {
//			Member mOne = mList.get(i);
//			if (memberId.equals(mOne.getMemberId())) {
//				mList.remove(i);
//				break;
//			}
//		}
//	}

	// 회원가입
	public void registerMember(Member member) {
		mList.add(member);
	}
	
	// 회원 정보 변경 - 1) 삭제 후 삽입 2) 교체 V
	public void modifyMember(int index, Member member) {
		mList.set(index, member);
	}

	// 회원 탈퇴
	public void withdrawMember(int index) {
		mList.remove(index);
	}

}
