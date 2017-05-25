package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.model.SimpleDao;

public class InsertController {

	public String execute(HttpServletRequest req) {
		try{
		SimpleDao dao = new SimpleDao();
		int sabun=Integer.parseInt(req.getParameter("sabun"));
		String name=req.getParameter("name");
		int pay=Integer.parseInt(req.getParameter("pay"));
		dao.insertOne(sabun, name, pay);
		}catch (Exception e) {
		}
		return "list.do";
	}
}
