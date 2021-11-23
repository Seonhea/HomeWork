package com.homework.join;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homework.join.member.model.vo.Member;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Member> memberList() throws Exception {
		List<Member> volist = sqlSession.selectList("Member.memberList");
		return volist;
	}
	
	public String signUp(Member member)  throws Exception {
		String result = sqlSession.selectOne("Member.signUp",member);
		return result;
	}

}
