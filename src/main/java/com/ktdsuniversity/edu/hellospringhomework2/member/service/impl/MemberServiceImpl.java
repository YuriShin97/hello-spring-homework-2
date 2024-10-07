package com.ktdsuniversity.edu.hellospringhomework2.member.service.impl;

import com.ktdsuniversity.edu.hellospringhomework2.common.beans.SHA;
import com.ktdsuniversity.edu.hellospringhomework2.member.dao.MemberDao;
import com.ktdsuniversity.edu.hellospringhomework2.member.service.MemberService;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.MemberVO;
import com.ktdsuniversity.edu.hellospringhomework2.member.vo.SignUpMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private SHA sha;
	
	@Override
	public boolean createNewMember(SignUpMemberVO signUpMemberVO) {
		
		  //1. salt발급
	      String salt = sha.generateSalt();
	      
	      //2. 사용자의 비밀번호 암호화
	      String password = signUpMemberVO.getPassword();
	      password = sha.getEncrypt(password, salt);

	      signUpMemberVO.setPassword(password);
	      signUpMemberVO.setSalt(salt);
		
//		int emailCount = this.memberDao.selectEmailCount(signUpMemberVO.getEmail());
//		if(emailCount > 0) {
//			throw new IllegalArgumentException("Email이 이미 사용중입니다.");
//		}
		int insertCount = this.memberDao.insertNewMember(signUpMemberVO);
		
		return insertCount > 0;
	}
	
	@Override
	public boolean checkAvailableEmail(String email) {
		return this.memberDao.selectEmailCount(email) == 0;
	}
	
	@Override
	public MemberVO readMember(LoginMemberVO loginMemberVO) {
		
		// 1. Salt 조회.
		String salt = this.memberDao.selectSalt(loginMemberVO.getEmail());
		if(salt == null) {
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		
		// 2. 사용자가 입력한 비밀번호를 salt 를 이용해 암호화.
		String password = loginMemberVO.getPassword();
		password = this.sha.getEncrypt(password, salt);
		loginMemberVO.setPassword(password);
		
		// 3. 이메일과 암호화된 비밀번호로 데이터베이스에서 회원 정보 조회.
		MemberVO memberVO = this.memberDao.selectOneMember(loginMemberVO);
		if(memberVO == null) {
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		
		return memberVO;
	}
}
