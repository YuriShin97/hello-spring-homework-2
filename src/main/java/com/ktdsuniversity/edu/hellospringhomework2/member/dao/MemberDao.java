package com.ktdsuniversity.edu.hellospringhomework2.member.dao;

import com.ktdsuniversity.edu.hellospringhomework2.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.MemberVO;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.SignUpMemberVO;

public interface MemberDao {
	
	public String NAMESPACE = "com.ktdsuniversity.edu.hellospringhomework2.member.dao.MemberDao";

	public int selectEmailCount(String email);
	
	public int insertNewMember(SignUpMemberVO signUpMemberVO);
	
	public String selectSalt(String email);
	
	public MemberVO selectOneMember(LoginMemberVO loginMemberVO);
}
