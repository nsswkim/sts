package com.hb.day01.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.day01.util.MyOracle;

public class SimpleDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	public List<SimpleVo> selectAll() throws SQLException{
		String sql="SELECT * FROM SIMPLE03 ORDER BY SABUN";
		List<SimpleVo> list=null;
		try{
			conn=MyOracle.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<SimpleVo>();
			while(rs.next()){
				list.add(new SimpleVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						));
			}
		}finally {
			closeAll();
		}
		return list;
	}

	public void insertOne(int sabun, String name, int pay) throws SQLException {
		String sql="INSERT INTO SIMPLE03 VALUES (?,?,SYSDATE,?)";
		try{
			conn=MyOracle.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			pstmt.executeUpdate();
		}finally {
			closeAll();
		}
		
	}

	public SimpleVo detailOne(int sabun) throws SQLException {
		String sql="SELECT * FROM SIMPLE03 WHERE SABUN=?";
		SimpleVo bean=null;
		try{
			conn=MyOracle.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean=new SimpleVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						);
			}
		}finally {
			closeAll();
		}
		return bean;
	}

	public int updateOne(int sabun, String name, int pay) throws SQLException {
		String sql="UPDATE SIMPLE03 SET "
				+ "NAME=?,NALJA=SYSDATE, PAY=? WHERE SABUN=?";
		try{
			conn=MyOracle.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, pay);
			pstmt.setInt(3, sabun);
			return pstmt.executeUpdate();
		}finally {
			closeAll();
		}
	}

	public int deleteOne(int sabun) throws SQLException {
		String sql="DELETE FROM SIMPLE03 WHERE SABUN=?";
		try{
			conn=MyOracle.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			return pstmt.executeUpdate();
		}finally {
			closeAll();
		}
	}

}
