package org.company.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.company.app.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
   @Autowired
   private SqlSession sqlSession;

@Override
public int insert(Member member) {
	// TODO Auto-generated method stub
	return sqlSession.insert("org.company.app.MemberMapper.insert",member);
}

@Override
public int update(Member member) {
	// TODO Auto-generated method stub
	return sqlSession.update("org.company.app.MemberMapper.update",member);
}

@Override
public int delete(String email) {
	// TODO Auto-generated method stub
	return sqlSession.delete("org.company.app.MemberMapper.delete", email);
}

@Override
public List<Member> selectList(String findvalue) {
	// TODO Auto-generated method stub
	return sqlSession.selectList("org.company.app.MemberMapper.selectList", findvalue);
}

@Override
public Member selectOne(String email) {
	// TODO Auto-generated method stub
	return sqlSession.selectOne("org.company.app.MemberMapper.selectOne", email);
	
}


   
}
