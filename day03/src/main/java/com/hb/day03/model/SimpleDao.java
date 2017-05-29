package com.hb.day03.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hb.day03.support.JdbcTemplate;
import com.hb.day03.support.RowMapper;

public class SimpleDao {
	
	public SimpleDao() {
	}

	public List<SimpleVo> selectAll() throws SQLException {
		String sql="SELECT * FROM SIMPLE02";
		JdbcTemplate jdbc= new JdbcTemplate();
		return jdbc.queryList(sql, new RowMapper(){

			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				while(rs.next()){
					SimpleVo bean= new SimpleVo();
					bean.setSabun(rs.getInt("sabun"));
					bean.setName(rs.getString("name"));
					bean.setNalja(rs.getString("nalja"));
					bean.setPay(rs.getInt("pay"));
					list.add(bean);
				}
				return list;
			}});
	}
	
	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql="SELECT * FROM SIMPLE02 WHERE SABUN=?";
		Object[] objs= new Object[]{sabun};
		JdbcTemplate jdbc = new JdbcTemplate();
		
		return (SimpleVo)jdbc.executeQuery(sql,objs,new RowMapper(){

			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				SimpleVo bean = new SimpleVo();
				if(rs.next()){
					bean.setSabun(rs.getInt("sabun"));
					bean.setName(rs.getString("name"));
					bean.setNalja(rs.getString("nalja"));
					bean.setPay(rs.getInt("pay"));
				}
				return bean;
			}
			
		});
	}
	
	public int insertOne(String name, String nalja, int pay) throws SQLException {
		String sql="INSERT INTO SIMPLE02 (NAME,NALJA,PAY) VALUES (?,?,?)";
		Object[] objs=new Object[]{name,nalja,pay};
		JdbcTemplate jdbc= new JdbcTemplate();
		return jdbc.executeUpdate(sql,objs);
	}

	public int updateOne(int sabun, String name, String nalja, int pay) throws SQLException {
		String sql="UPDATE SIMPLE02 SET NAME=?,NALJA=?,PAY=? WHERE SABUN=?";
		Object[] objs=new Object[]{name,nalja,pay,sabun};
		JdbcTemplate jdbc= new JdbcTemplate();
		return jdbc.executeUpdate(sql,objs);
	}
	
	public int deleteOne(int sabun) throws SQLException{
		String sql="DELETE FROM SIMPLE02 WHERE SABUN=?";
		JdbcTemplate jdbc= new JdbcTemplate();
		return jdbc.executeUpdate(sql, new Object[]{sabun});
	}

}
