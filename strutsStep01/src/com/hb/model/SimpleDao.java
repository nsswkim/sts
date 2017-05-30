package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hb.util.MyOracle;

public class SimpleDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<Map<String, Object>> selectAll() throws SQLException{
		String sql="SELECT * FROM SIMPLE02 ORDER BY SABUN";
		List<Map<String, Object>> list = new ArrayList<>();
		try{
		conn=MyOracle.getConnection();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()){
			Map<String, Object> map = new HashMap<>();
			map.put("sabun", rs.getInt("sabun"));
			map.put("name", rs.getString("name"));
			map.put("nalja", rs.getString("nalja"));
			map.put("pay", rs.getInt("pay"));
			list.add(map);
		}
		}finally {
			closeAll();
		}
		return list;
	}
	
	public Map<String, Object> selectOne(int sabun) throws SQLException{
		String sql="SELECT * FROM SIMPLE02 WHERE SABUN=?";
		Map<String, Object> map = new HashMap<>();
		try{
			conn=MyOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs=pstmt.executeQuery();
			while(rs.next()){
				map.put("sabun", rs.getInt("sabun"));
				map.put("name", rs.getString("name"));
				map.put("nalja", rs.getString("nalja"));
				map.put("pay", rs.getInt("pay"));
			}
			}finally {
				closeAll();
			}
		return map;
	}

	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

	public int insertOne(String name, String nalja, int pay) throws SQLException {
		String sql="insert into simple02 (name,nalja,pay) ";
		sql+=" values (?,?,?)";
		try{
			conn=MyOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, nalja);
			pstmt.setInt(3, pay);
			return pstmt.executeUpdate();
		}finally {
			closeAll();
		}
	}
}








