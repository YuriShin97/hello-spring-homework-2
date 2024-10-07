package com.ktdsuniversity.edu.hellospringhomework2.member.service;

import com.ktdsuniversity.edu.hellospringhomework2.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.MemberVO;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.SignUpMemberVO;

public interface MemberService {
	
	public boolean createNewMember(SignUpMemberVO signUpmemberVO);
	
	public boolean checkAvailableEmail(String email);
	
	public MemberVO readMember(LoginMemberVO loginMemberVO);
}
