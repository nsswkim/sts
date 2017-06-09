package com.hb.day02.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class GuestUserDaoImpl implements GuestUserDao<GuestUserVo> {
	@Autowired
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Logger log = Logger.getLogger(this.getClass());
	
	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	@Override
	public List<GuestUserVo> selectAll() throws SQLException {
		String sql="SELECT * FROM GUEST_USER ORDER BY NUM";
		List<GuestUserVo> list=null;
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<GuestUserVo>();
			while(rs.next()){
				list.add(new GuestUserVo(
						rs.getInt("num")
						,rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						));
			}
		}finally {
			closeAll();
		}
		return list;
	}


	@Override
	public GuestUserVo selectOne(int idx) throws SQLException {
		String sql="SELECT * FROM GUEST_USER WHERE NUM=?";
		GuestUserVo bean=null;
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean=new GuestUserVo(
						rs.getInt("num")
						,rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						);
			}
			log.debug(bean);
		}finally {
			closeAll();
		}
		return bean;
	}

	@Override
	public void insertOne(GuestUserVo bean) throws SQLException {
		String sql="insert into guest_user values "
				+ "((select max(num)+1 from GUEST_USER),?,?,sysdate)";
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.executeUpdate();
		}finally {
			closeAll();
		}
	}

	@Override
	public int updateOne(GuestUserVo bean) throws SQLException {
		String sql="UPDATE GUEST_USER SET SABUN=?,NAME=? WHERE NUM=?";
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getNum());
			return pstmt.executeUpdate();
		}finally {
			closeAll();
		}
	}

	@Override
	public int deleteOne(int idx) throws SQLException {
		String sql="DELETE FROM GUEST_USER WHERE NUM=?";
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			return pstmt.executeUpdate();
		}finally {
			closeAll();
		}
	}

}
