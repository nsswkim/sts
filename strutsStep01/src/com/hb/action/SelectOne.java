package com.hb.action;

import java.util.Map;

import com.hb.model.SimpleDao;
import com.opensymphony.xwork2.ActionSupport;

public class SelectOne extends ActionSupport {
	private int sabun;
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	private Map<String, Object> bean;
	public Map<String, Object> getBean() {
		return bean;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(sabun);
		SimpleDao dao = new SimpleDao();
		bean=dao.selectOne(sabun);
		
		return this.SUCCESS;
	}
}
