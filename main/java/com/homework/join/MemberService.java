package com.homework.join;

import java.util.List;

import com.homework.join.member.model.vo.Member;

public interface MemberService {
	public List<Member> memberList() throws Exception;
	public String signUp(Member member) throws Exception;
}
