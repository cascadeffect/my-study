package com.kh.member.model.vo;

// 데이터 저장용 클래스
public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private String memberEmail;
	private String memberAddress;
	private String memberPhoneNum;
	private String memberHobby;

	public Member() {

	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberPhoneNum() {
		return memberPhoneNum;
	}

	public void setMemberPhoneNum(String memberPhoneNum) {
		this.memberPhoneNum = memberPhoneNum;
	}

	public String getMemberHobby() {
		return memberHobby;
	}

	public void setMemberHobby(String memberHobby) {
		this.memberHobby = memberHobby;
	}

	@Override
	public String toString() {
		return "회원정보 [아이디:" + memberId + ", 비밀번호: " + memberPw + ", 이름: " + memberName + ", 나이: " + memberAge + ", 성별: "
				+ memberGender + ", 이메일: " + memberEmail + ", 주소: " + memberAddress + ", 전화번호: " + memberPhoneNum
				+ ", 취미: " + memberHobby + "]";
	}

}
