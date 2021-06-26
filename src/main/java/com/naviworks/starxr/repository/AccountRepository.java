package com.naviworks.starxr.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naviworks.starxr.vo.UserVo;

@Repository
public class AccountRepository {

	@Autowired
	SqlSession sqlSession;

	public void modify(UserVo userVo) {
		sqlSession.update("account.modify",userVo);
	}
}
