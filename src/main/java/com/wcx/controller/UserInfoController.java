package com.wcx.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.wcx.bean.UserInfo;
import com.wcx.biz.IUserInfoBiz;

@Controller
public class UserInfoController {
	@Autowired
	private IUserInfoBiz userInfoBiz;
	
	@RequestMapping("/front/userLogin")
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
	
	@RequestMapping("/front/userRegister")
	@ResponseBody
	public Integer userReg(UserInfo userInfo){
		int result = this.userInfoBiz.userReg(userInfo);
		return result;
		
	}

	/**
	 * 添加
	 * @param session
	 * @param userInfo
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public Integer addUser(HttpSession session,UserInfo userInfo){
		System.out.println(userInfo);
		int result=this.userInfoBiz.addUser(userInfo);
		return result;
	}
	
	/**
	 * 分页查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/userfindByPage")
	@ResponseBody
	public String findAllBlogType(HttpServletRequest request){
		Integer pageNo = Integer.parseInt(request.getParameter("page"));
		Integer pageSize = Integer.parseInt(request.getParameter("rows"));
		Gson gson=new Gson();
		return gson.toJson(this.userInfoBiz.userfindByPage(pageNo, pageSize));
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Integer deleteUser(Integer ids,HttpServletResponse response){
		System.out.println("ids= "+ids);
		Integer result=this.userInfoBiz.deleteUser(ids);
		return result;
	}
	
	/**
	 * 修改图片
	 * @param photos
	 * @param session
	 * @return
	 */
	@RequestMapping("/updateUPhoto")
	@ResponseBody
	public String updateUPhoto(@RequestParam("wcxuphotos") MultipartFile wcxuphotos,HttpSession session){
		if(wcxuphotos!=null && wcxuphotos.getSize()>0){
			try {
				String path=session.getServletContext().getRealPath("");
				String savePath="/uploadfile/"+new Date().getTime()+"_"+wcxuphotos.getOriginalFilename();
				File dest=new File( new File(path).getParentFile(),savePath);
				wcxuphotos.transferTo(dest);
				UserInfo lg=(UserInfo) session.getAttribute("currentLoginLeaguer");
				int result=this.userInfoBiz.updateUPhoto(lg.getWcxuid(), savePath);
				if(result<=0){
					return null;
				}else{
					lg.setWcxuphoto(savePath);
					session.setAttribute("currentLoginUser", lg);
					return savePath;
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
