package com.hb.day03.support;

import java.util.HashMap;
import java.util.Map;

public class HendlerMapping {
	
	private static Map<String,String> map=new HashMap<>();
	
	public static void setMap(String key, String value){
		map.put(key, value);
	}

	public static MyController mapping(String uri) {
		MyController controller=null;
		try{
			Class clzz=Class.forName(map.get(uri));
			controller=(MyController) clzz.newInstance();
		}catch (Exception e) {
		}
		
		return controller;
	}

}
