package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport{
	private Logger log = Logger.getLogger(this.getClass());
	private SimpleVo bean = new SimpleVo();
	
	public SimpleVo getBean() {
		return bean;
	}
	public void setBean(SimpleVo bean) {
		this.bean = bean;
	}
//	private int sabun;
//	private String name;
//	private int pay;
//	
//	public int getSabun() {
//		return sabun;
//	}
//	public void setLog(Logger log) {
//		this.log = log;
//	}
//
//	public void setSabun(int sabun) {
//		this.sabun = sabun;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setPay(int pay) {
//		this.pay = pay;
//	}
	
	private boolean isValidate() {
		if(bean.getSabun()==0)return false;
		if(bean.getName()==null || "".equals(bean.getName())) return false;
		if(bean.getPay()==0)return false;
//		if(sabun==0)return false;
//		if(name==null || "".equals(name)) return false;
//		if(pay==0)return false;
		return true;
	}

	@Override
	public String execute() throws Exception {
		log.debug(bean);
		if(isValidate())
			return SUCCESS;
		else
			return INPUT;
	}
	
	
	
	
}
