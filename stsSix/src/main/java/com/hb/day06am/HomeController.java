package com.hb.day06am;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.day06am.model.GuestDao;
import com.hb.day06am.model.GuestVo;
import com.hb.day06am.service.ServiceCommand;
import com.hb.day06am.service.ServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private ServiceCommand service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("/guest/list")
	public void listPage(Model model) throws SQLException{
		service.listService(sqlSession, model);
	}
	
	/*validation*/
	@RequestMapping(value="/guest/add",method=RequestMethod.GET)
	public void addPage(){
	}
	@RequestMapping(value="/guest/add",method=RequestMethod.POST)
	public String insertPage(@Valid GuestVo bean, BindingResult br, Model model) throws SQLException{
		if(br.hasErrors()){
		List<ObjectError> err =br.getAllErrors();
		for(int i =0; i<err.size(); i++){
			System.out.println(err.get(i).getCodes()[1]);
			Map<String, String> errMsg=new HashMap<String, String>();
			
			if("typeMismatch.sabun".equals(err.get(i).getCodes()[1])){
				errMsg.put("sabun", "사번이 비었습니다");
			}else if ("typeMismatch.pay".equals(err.get(i).getCodes()[1])) {
				errMsg.put("pay", "금액이 비었습니다");
			}else if ("Email.name".equals(err.get(i).getCodes()[1])){
				errMsg.put("name", "이메일 형식이 아닙니다.");		
		}else if ("Size.name".equals(err.get(i).getCodes()[1])){
			errMsg.put("name", "비어있음.");		
		}
			model.addAttribute("bean", bean);
			model.addAttribute("err", errMsg);
		}
			return "guest/add";
		}
		service.addService(sqlSession, bean);
		return "redirect:list";
	}
	
	
	
	@RequestMapping("/guest/detail/{idx}")
	public String detailPage(@PathVariable int idx,Model model) throws SQLException{
		service.detailService(sqlSession, model, idx);
		return "guest/detail";
	}
	@RequestMapping(value="/guest/edit/{idx}"
			,method=RequestMethod.GET)
	public String editPage(@PathVariable int idx,Model model) throws SQLException{
		service.detailService(sqlSession, model, idx);
		return "guest/edit";
	}
	
	@RequestMapping(value="/guest/edit/{idx}"
			,method=RequestMethod.POST)
	public String updatePage(@ModelAttribute GuestVo bean
			,@PathVariable int idx) throws SQLException{
		service.editService(sqlSession, bean);
		return "redirect:../detail/"+idx;
	}
	
	@RequestMapping(value="/guest/del/{idx}")
	public String deletePage(@PathVariable int idx) throws SQLException{
		service.deleteService(sqlSession, idx);
		return "redirect:../list";
	}
}