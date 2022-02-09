package org.company.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.company.app.dao.MemberDAO;
import org.company.app.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public List<Member> selectList(String findvalue) {
		return memberDAO.selectList(findvalue);
	}

	@Override
	public Member selectOne(String email) {
		// TODO Auto-generated method stub
		return memberDAO.selectOne(email);
	}
	
	@Transactional
	@Override
	public Map<String, Object> insert(Member member) throws Exception {
		Map<String, Object> result = new HashMap<>();
		//code : msg
		//0:정상
		//1:중복된 아이디
		
		//1)중복된 회원인지 체크
		Member dbmember = memberDAO.selectOne(member.getEmail());
		if (dbmember != null) { //회원이 존재할경우
			result.put("code", 1);
			result.put("msg", "중복된 아이디");
			return result;
		
		
		}
		
		
		
		//3)비밀번호 암호화
		//일단 빼고
//		String cryptPassword=bCryptPasswordEncoder.encode(member.getPasswd());
//		member.setPasswd(cryptPassword);
		//4)db저장
		int cnt = memberDAO.insert(member);
		result.put("code", 0);
		result.put("msg", "정상");
		return result;
	}

		

	@Override
	public Map<String, Object> update(Member member) {
		Map<String, Object> result = new HashMap<>();
		Member dbmember =memberDAO.selectOne(member.getEmail());
		 if(dbmember.getSimplejoin().equals("0")) {
			 boolean match= bCryptPasswordEncoder.matches(member.getPasswd(), dbmember.getPasswd());
			 if(!match) {
				 result.put("code", 1);
				 result.put("msg", "기존비밀번호 불일치");
				 return result;
			 }
			 
		 }
		return null;
		
	}

	
	
}
