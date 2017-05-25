package com.hb.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hb.engine.FrontImp;
import com.hb.model.SimpleDao;

public class ListController implements FrontImp {

	public String execute(HttpServletRequest req){
		
		SimpleDao dao;
		try {
			dao = new SimpleDao();
			List list=dao.selectAll();
			req.setAttribute("alist", list);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/list.jsp";
	}
}
