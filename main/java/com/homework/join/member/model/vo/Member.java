package com.homework.join.member.model.vo;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberNm;
	private String memberEnrollDt;
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberNm=" + memberNm
				+ ", memberEnrollDt=" + memberEnrollDt + ", getMemberId()=" + getMemberId() + ", getMemberPwd()="
				+ getMemberPwd() + ", getMemberNm()=" + getMemberNm() + ", getMemberEnrollDt()=" + getMemberEnrollDt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberNm() {
		return memberNm;
	}
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}
	public String getMemberEnrollDt() {
		return memberEnrollDt;
	}
	public void setMemberEnrollDt(String memberEnrollDt) {
		this.memberEnrollDt = memberEnrollDt;
	}
}
