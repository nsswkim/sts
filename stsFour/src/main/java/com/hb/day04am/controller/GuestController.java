package com.hb.day04am.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hb.day04am.model.dao.GuestDao;
import com.hb.day04am.model.dto.GuestVo;

@Controller
public class GuestController {
	@Autowired
	private GuestDao guestDao;

	@RequestMapping("guest/list")
	public void selectAll(Model model){
		try {
			model.addAttribute("alist", guestDao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="guest/add",method=RequestMethod.GET)
	public void addForm(){
	}
	
	@RequestMapping(value="guest/add",method=RequestMethod.POST)
	public String insertOne(@ModelAttribute GuestVo bean){
		try {
			guestDao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}	
	
	@RequestMapping("/guest/detail/{idx}")
	public ModelAndView selectOne(@PathVariable int idx, ModelAndView mav){
		try {
			mav.addObject("bean", guestDao.selelctOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mav.setViewName("guest/detail");
		return mav;
		
		}
	}


