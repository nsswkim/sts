package com.hb.day02.support;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day02.controller.AddController;
import com.hb.day02.controller.InsertController;
import com.hb.day02.controller.ListController;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		HandlerMapping.setMap("/day02/list.do", "com.hb.day02.controller.ListController");
		HandlerMapping.setMap("/day02/add.do", "com.hb.day02.controller.AddController");
		HandlerMapping.setMap("/day02/insert.do", "com.hb.day02.controller.InsertController");
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// /list.do		,get		->	/page/list.jsp ->list
		// /detail.do	,get		->	/page/detail.jsp ->detail
		// /add.do		,get		->	/page/form.jsp	->form
		// /insert.do	,post	->	redirect:list.do	->redirect:list.do
		// /edit.do		,get		->	/page/form.jsp 재사용
		// /update.do	,post	->	redirect:detail.do
		// /del.do		,post	->	redirect:detail.do
		
		//controller
		String uri=request.getRequestURI();
		MyController controller=HandlerMapping.mapping(uri);
		String pname=controller.execute(request, response);
		
		
		//view
		String url=null;
		if(pname.startsWith("redirect:")){
			url=pname.replace("redirect:", "");
			response.sendRedirect(url);
			return;
		}
		
		String prifix="/page/";
		String sufix=".jsp";
		url=prifix+pname+sufix;
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
