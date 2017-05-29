package com.hb.day03.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day03.model.SimpleDao;
import com.hb.day03.support.MyController;

public class SelectAll implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			req.setAttribute("alist",(List)new SimpleDao().selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "list";
	}

}
