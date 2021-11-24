package com.homework.join;

import java.util.List;

import com.homework.join.member.model.vo.Member;

public interface MemberService {
	public List<Member> memberList() throws Exception;
	public int signUp(Member vo) throws Exception;
//	public int signUp(String mId, String mPwd, String mName) throws Exception;
}
