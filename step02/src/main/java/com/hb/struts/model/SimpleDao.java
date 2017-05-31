package com.hb.struts.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

public class SimpleDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public SimpleDao() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="oracle";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SimpleVo> selectAll() throws SQLException{
		List<SimpleVo> list = new ArrayList<>();
		String sql="SELECT * FROM SIMPLE03 ORDER BY SABUN";
		try{
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()){
			list.add(new SimpleVo(rs.getInt("sabun"),
					rs.getString("name"),
					rs.getDate("nalja"),
					rs.getInt("pay")
					));
		}
		}finally {
			closeAll();
		}
		return list;
	}

	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
	}

	public int insertOne(int sabun, String name, int pay) throws SQLException {
		int result=0;
		String sql="INSERT INTO SIMPLE03 VALUES (?,?,SYSDATE,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			result=pstmt.executeUpdate();
		}finally {
			closeAll();
		}
		return result;
	}
	
	public int insertOne(SimpleVo bean) throws SQLException {
		int result=0;
		String sql="INSERT INTO SIMPLE03 VALUES (?,?,SYSDATE,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			result=pstmt.executeUpdate();
		}finally {
			closeAll();
		}
		return result;
	}

	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql="select * from simple03 where sabun=?";
		SimpleVo bean=new SimpleVo();
		
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
			}
		}finally {
			closeAll();
		}
		
		return bean;
	}
	
}







