package com.hb.engine;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.SimpleDao;


public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="/";
		String path=req.getRequestURI();
		
		try {
			SimpleDao dao = new SimpleDao();
			
			if(path.equals("/day01/list.do")){
				url+="list";
				List list=dao.selectAll();
				req.setAttribute("alist", list);
			}else if(path.equals("/day01/detail.do")){
				url+="detail";
				Map<String,Object> map=dao.selectOne(Integer.parseInt(req.getParameter("idx")));
				req.setAttribute("bean", map);
			}else if(path.equals("/day01/add.do")){
				url+="add";
			}
			url+=".jsp";
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//view
		req.getRequestDispatcher(url).forward(req, resp);
	}
}









