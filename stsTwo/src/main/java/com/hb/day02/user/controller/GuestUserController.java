package com.hb.day02.user.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.day02.user.model.GuestUserDao;
import com.hb.day02.user.model.GuestUserVo;

@Controller
public class GuestUserController {
	@Autowired
	private GuestUserDao<GuestUserVo> guestUserDao;

	@RequestMapping("/user/list")
	public void selectAll(Model model){
		try {
			model.addAttribute("alist", guestUserDao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
