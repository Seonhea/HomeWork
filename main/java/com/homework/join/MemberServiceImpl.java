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
	public int signUp(Member vo)  throws Exception {
		return memberDAO.signUp(vo);
	}
//	public int signUp(String mId, String mPwd, String mName) throws Exception {
//		return memberDAO.signUp(mId, mPwd, mName);
//	}
}
