package org.company.app.service;

import java.util.List;
import java.util.Map;

import  org.company.app.dto.Member;

public interface MemberService {

	List<Member> selectList(String findvalue);

	Member selectOne(String email);

	Map<String, Object> insert(Member member) throws Exception;
	


	Map<String, Object> update(Member member);

}
