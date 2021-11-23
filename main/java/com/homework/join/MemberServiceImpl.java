package com.homework.join;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.join.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	public MemberDAO memberDAO;
	
	public List<Member> memberList() throws Exception{
		List<Member> volist = memberDAO.memberList();
		return volist;
}
	public String signUp(Member member)  throws Exception {
		String result = memberDAO.signUp(member);
		return result;
	}
}
