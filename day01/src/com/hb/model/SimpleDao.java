package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SimpleDao() throws ClassNotFoundException, SQLException {
		Connection myconn=null;
		Class.forName("org.h2.Driver");
		myconn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		conn=myconn;
	}
	public SimpleDao(boolean auto) throws ClassNotFoundException, SQLException{
		Connection myconn=null;
		Class.forName("org.h2.Driver");
		myconn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		myconn.setAutoCommit(auto);
		conn=myconn;
	}
	
	public void close() throws SQLException{
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	public void back() throws SQLException{
		conn.rollback();
		close();
	}
	
	public List<Map<String,Object>> selectAll() throws SQLException{
		String sql="SELECT * FROM SIMPLE01";
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("sabun", rs.getInt("sabun"));
			map.put("name", rs.getString("name"));
			map.put("nalja", rs.getDate("nalja"));
			map.put("pay", rs.getInt("pay"));
			list.add(map);
		}
		return list;
	}
	
	public Map<String,Object> selectOne(int sabun) throws SQLException{
		String sql="select * from simple01 where sabun=?";
		Map<String,Object> map = new HashMap<>();
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, sabun);
		rs=pstmt.executeQuery();
		if(rs.next()){
			map.put("sabun", rs.getInt("sabun"));
			map.put("name", rs.getString("name"));
			map.put("nalja", rs.getDate("nalja"));
			map.put("pay", rs.getInt("pay"));
		}
		return map;
	}
	
	public int insertOne(int sabun, String name, int pay) throws SQLException{
		int result=0;
		String sql="INSERT INTO SIMPLE01 VALUES (?,?,SYSDATE,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, sabun);
		pstmt.setString(2, name);
		pstmt.setInt(3, pay);
		result=pstmt.executeUpdate();
		return result;
	}

}












