package com.hb.spring2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.spring2.util.MyOracle;

public class SimpleDao implements DaoImpl {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public SimpleDao() {
//		try{
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn=DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe"
//					, "system", "oracle");
//			
//		}catch (Exception e) {
//		}
	}
	
	public List<SimpleVo> selectAll() throws SQLException{
		String sql="SELECT * FROM SIMPLE03 ORDER BY SABUN";
		List<SimpleVo> list = null;
		try{
			conn=MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<>();
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

	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

	public void insertOne(SimpleVo simpleVo) throws SQLException {
		String sql="INSERT INTO SIMPLE03 VALUES (?,?,SYSDATE,?)";
		try{
			conn=MyOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, simpleVo.getSabun());
			pstmt.setString(2, simpleVo.getName());
			pstmt.setInt(3, simpleVo.getPay());
			pstmt.executeUpdate();
		}finally {
			closeAll();
		}
	}

	@Override
	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql="SELECT * FROM SIMPLE03 WHERE SABUN=?";
		SimpleVo bean=null;
		try{
			conn=MyOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean=new SimpleVo(rs.getInt("sabun")
						, rs.getString("name")
						, rs.getDate("nalja")
						, rs.getInt("pay"));
			}
		}finally {
			closeAll();
		}
		return bean;
	}

	@Override
	public int updateOne(SimpleVo bean) {
		// TODO Auto-generated method stub
		return 0;
	}
}












