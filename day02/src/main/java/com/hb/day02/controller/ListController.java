package com.hb.day02.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day02.model.SimpleDao;
import com.hb.day02.support.MyController;

public class ListController implements MyController{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDao dao = new SimpleDao();
		try {
			request.setAttribute("alist", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list";
	}

}
