package com.wcx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wcx.bean.Manager;
import com.wcx.biz.WcxmanagerBiz;

@Controller
public class ManagerController {
	@Autowired
	private WcxmanagerBiz wcxmanagerBiz;
	
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
	
	/**
	 * 分页查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/manfindByPage")
	@ResponseBody
	public String manfindByPage(HttpServletRequest request){
		Integer pageNo = Integer.parseInt(request.getParameter("page"));
		Integer pageSize = Integer.parseInt(request.getParameter("rows"));
		Gson gson=new Gson();
		return gson.toJson(this.wcxmanagerBiz.manfindByPage(pageNo, pageSize));
	}
	
	@RequestMapping("/addManager")
	@ResponseBody
	public Integer addManager(HttpSession session,Manager manager){
		int result=this.wcxmanagerBiz.addManager(manager);
		return result;
	}
	
	@RequestMapping("/deleteManager")
	@ResponseBody
	public Integer deleteManager(Integer ids,HttpServletResponse response){
		System.out.println("ids= "+ids);
		Integer result=this.wcxmanagerBiz.deleteManager(ids);
		return result;
	}
}
