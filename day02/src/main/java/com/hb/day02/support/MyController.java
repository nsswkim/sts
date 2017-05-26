package com.hb.day02.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyController {

	String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
