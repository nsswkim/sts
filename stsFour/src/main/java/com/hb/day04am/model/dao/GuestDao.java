package com.hb.day04am.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.hb.day04am.model.dto.GuestVo;

public interface GuestDao {
	
	List<GuestVo> selectAll() throws SQLException;
	GuestVo selelctOne(int sabun) throws SQLException;
	void insertOne(GuestVo bean) throws SQLException;
	void update(GuestVo bean) throws SQLException;
	int deleteOne(int sabun) throws SQLException;
	
}
