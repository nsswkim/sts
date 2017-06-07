package com.hb.spring3.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleDaoImplTest {

	private static SimpleDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		BasicDataSource ds=null;
//			ds=new org.apache.tomcat.dbcp.dbcp.BasicDataSource();
//			ds.setDriverClassName("oracle.jdbc.OracleDriver");
//			ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//			ds.setUsername("system");
//			ds.setPassword("oracle");
//		dao=new SimpleDaoImpl(ds);
		
		ApplicationContext ac
		=new ClassPathXmlApplicationContext("/context-config.xml");
		dao=(SimpleDaoImpl)ac.getBean("simpleDao");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAll() throws SQLException {
		List<SimpleVo> list=dao.SelectAll();
		if(list!=null){
			assertTrue(true);
			assertTrue(list.size()>0);
			return;
		}
		fail("Not yet implemented");
	}

	@Test
	public void testSelectOne() throws SQLException {
		//1111 admin 2017-05-01 1000 
		SimpleVo me = new SimpleVo(1111,"admin",null,1000);
		SimpleVo bean=dao.selectOne(me.getSabun());
//		if(me.equals(bean)){
//			assertTrue(true);
//			return;
//		}
		assertEquals(me, bean);
	}

	@Test
	public void testInsertOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testPayPlus() {
		fail("Not yet implemented");
	}

}
