package com.ktdsuniversity.edu.hellospringhomework2.member.dao.impl;

import com.ktdsuniversity.edu.hellospringhomework2.member.dao.MemberDao;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.MemberVO;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.SignUpMemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int selectEmailCount(String email) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectEmailCount", email);
	}
	
	@Override
	public int insertNewMember(SignUpMemberVO signUpMemberVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewMember", signUpMemberVO);
	}
	
	@Override
	public String selectSalt(String email) {
		return getSqlSession().selectOne(NAMESPACE + ".selectSalt", email);
	}
	
	@Override
	public MemberVO selectOneMember(LoginMemberVO loginMemberVO) {
		return getSqlSession().selectOne(NAMESPACE + ".selectOneMember", loginMemberVO);
	}
}
