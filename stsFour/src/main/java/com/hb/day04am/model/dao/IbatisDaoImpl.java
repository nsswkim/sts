package com.hb.day04am.model.dao;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.hb.day04am.model.dto.GuestVo;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisDaoImpl implements GuestDao {
	
	private SqlMapClient sqlMapClient;
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	public IbatisDaoImpl() {
		// 생성자 주입에서 ->setter 을 이용한 빈으로 주입
	/*	String path="./sqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			sqlMapClient= SqlMapClientBuilder.buildSqlMapClient(reader);
						
		} catch (Exception e) {
		}	*/
	}
	

	@Override
	public List<GuestVo> selectAll() throws SQLException {
		List<GuestVo> list = sqlMapClient.queryForList("selectAll");		
		return list;
	}

	@Override
	public GuestVo selelctOne(int sabun) throws SQLException {		
		 return (GuestVo) sqlMapClient.queryForObject("selectOne", sabun);
		
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		sqlMapClient.insert("insertOne",bean);
		
	}

	@Override
	public void update(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
