package com.hb.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleDaoTest {
	static Logger log=Logger.getLogger(SimpleDaoTest.class);
	static SimpleDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		dao = new SimpleDao(false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		dao.back();
	}

	@Before
	public void setUp() throws Exception {
		dao = new SimpleDao(false);
	}

	@After
	public void tearDown() throws Exception {
		dao.back();
	}

	@Test
	public void testSimpleDao() throws ClassNotFoundException, SQLException {
		Assert.assertNotNull(new SimpleDao());
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		List<Map<String,Object>> list=dao.selectAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size()>0);
		Assert.assertSame(5, list.size());
		for (Map<String, Object> map : list) {
			log.debug(map.get("sabun"));//log4j.properties
		}
	}

	@Test
	public void testSelectOne() throws ClassNotFoundException, SQLException{
		int sabun=1000;
		Map<String,Object> map=dao.selectOne(sabun);
		Assert.assertNotNull(map);
		Assert.assertEquals(sabun, map.get("sabun"));
		Assert.assertEquals("aaaa", map.get("name"));
		Assert.assertEquals(1111, map.get("pay"));
	}
	
	@Test
	public void testInsertOne() throws SQLException{
		int sabun=4000;
		int pay=4444;
		String name="test";
		int result=dao.insertOne(sabun, name, pay);
		Assert.assertSame(1, result);
	}
}













