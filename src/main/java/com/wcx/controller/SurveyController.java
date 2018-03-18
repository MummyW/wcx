package com.wcx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wcx.bean.Survey;
import com.wcx.bean.UserInfo;
import com.wcx.biz.IWCXSurveyBiz;

/** 
 * @author 作者:Mummy QQ:1962978637 
 * @date 创建时间:2018年3月15日下午8:29:40
 * @ClassName 
 * @Description
 * @record 修改记录:
 * @version 1.0 
 */
@Controller
public class SurveyController {

	@Autowired
	private IWCXSurveyBiz surveyService;

	@RequestMapping("/front/addSurvey")
	@ResponseBody
	public String addSurvey(HttpSession session ,Survey survey){
		session.setAttribute("wcxsname",survey.getWcxsname());
		Gson gson = new Gson();
		return gson.toJson(1);
	}

	@RequestMapping("/front/commitSurvey")
	@ResponseBody
	public String commitSurvey(HttpSession session ,Survey survey){
		UserInfo userInfo = (UserInfo)session.getAttribute("currentLoginUser");
		survey.setWcxuid(userInfo.getWcxuid());
		int result = surveyService.addSurvey(survey);
		Gson gson = new Gson();
		return gson.toJson(result);
	}
}
