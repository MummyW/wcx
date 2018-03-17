package com.wcx.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wcx.bean.UserInfo;
import com.wcx.biz.IUserInfoBiz;
import com.wcx.util.MD5Encryption;

@Controller
public class UserInfoController {
	@Autowired
	private IUserInfoBiz userInfoBiz;
	
	@RequestMapping("/front/userLogin")
	@ResponseBody
	public String userLogin(HttpSession session,UserInfo userInfo){
		userInfo.setWcxupwd(MD5Encryption.createPassword(userInfo.getWcxupwd()));
		UserInfo user = this.userInfoBiz.userInfoLogin(userInfo.getWcxuname(), userInfo.getWcxupwd());;
		Gson gson = new Gson();
		if(user == null){
			return gson.toJson(null);
		}else{
			session.setAttribute("currentLoginUser", user);
			return gson.toJson(user);
		}
	}
	
	@RequestMapping("/front/userRegister")
	@ResponseBody
	public Integer userReg(UserInfo userInfo){
		int result = this.userInfoBiz.userReg(userInfo);
		return result;
		
	}
}
