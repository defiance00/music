package org.company.app.dao;

import java.util.List;

import org.company.app.dto.Member;

public interface MemberDAO {
	int insert(Member member);
	int update(Member member);
	int delete(String email);
	List<Member> selectList(String findvalue);
	Member selectOne(String email);
	
}
