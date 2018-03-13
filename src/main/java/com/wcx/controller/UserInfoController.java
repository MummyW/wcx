package com.wcx.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wcx.bean.UserInfo;
import com.wcx.biz.IUserInfoBiz;

@Controller
public class UserInfoController {
	@Autowired
	private IUserInfoBiz userInfoBiz;
	
	@RequestMapping("/userLogin")
	@ResponseBody
	public String userLogin(HttpSession session,String uname,String pwd){
		UserInfo userInfo = this.userInfoBiz.userInfoLogin(uname, pwd);
		Gson gson = new Gson();
		if(userInfo == null){
			return gson.toJson(null);
		}else{
			session.setAttribute("currentLoginUser", userInfo);
			return gson.toJson(userInfo);
		}
	}
	
	@RequestMapping("/userRegister")
	@ResponseBody
	public Integer userReg(UserInfo userInfo){
		System.out.println(1);
		int result = this.userInfoBiz.userReg(userInfo);
		return result;
		
	}
}
