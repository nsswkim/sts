package com.hb.day04pm.model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hb.day04pm.model.dto.GuestVo;

public class GuestDaoImpl1 implements GuestDao {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		List<GuestVo> list = sqlSession.selectList("guest.selectAll");
		System.out.println(list);
		return list;
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		
		return sqlSession.selectOne("guest.selectOne", sabun);
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		sqlSession.insert("guest.insertOne",bean);
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		
		return sqlSession.update("guest.updateOne",bean);
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		
		return sqlSession.delete("guest.deleteOne",sabun);
	}

}