package com.wcx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wcx.bean.Manager;
import com.wcx.biz.IWcxmanagerBiz;

@Controller
public class ManagerController {
	@Autowired
	private IWcxmanagerBiz wcxmanagerBiz;
	
	@RequestMapping("/back/managerLogin")
	@ResponseBody
	public String managerLogin(HttpSession session,String wcxmname,String wcxmpwd){
		System.out.println(wcxmname);
		System.out.println(wcxmpwd);
		Manager manager=this.wcxmanagerBiz.managerLogin(wcxmname, wcxmpwd);
		System.out.println(manager);
		Gson gson=new Gson();
		if(manager==null){
			return gson.toJson(null);
		}else{
			session.setAttribute("currentLoginManager", manager);
			return gson.toJson(manager);
		}
	}
	
}
