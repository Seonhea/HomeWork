package com.homework.join;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homework.join.member.model.vo.Member;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;//root-context에 정의한 bean 이름과 일치하게 쓰는것을 강력추천.(다르게 쓰면 동작안할 확률 있음)
	
	public List<Member> memberList() throws Exception {
		List<Member> volist = sqlSessionTemplate.selectList("Member.memberList");
		return volist;
	}
	
	public int signUp(Member vo)  throws Exception {
		System.out.println("dao arg: "+vo);

		int result = sqlSessionTemplate.insert("Member.signUp",vo);
		return result;
	}
//	public int signUp(String mId, String mPwd, String mName) throws Exception {
//		int result = sqlSessionTemplate.insert("Member.signUp2", mId, mPwd, mName);
//		return result;	
//	}

}
