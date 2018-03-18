package com.wcx.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcx.bean.Survey;
import com.wcx.biz.IWCXSurveyBiz;
import com.wcx.dao.BaseDao;

/** 
 * @author 作者:Mummy QQ:1962978637 
 * @date 创建时间:2018年3月16日下午8:21:47
 * @ClassName 
 * @Description
 * @record 修改记录:
 * @version 1.0 
 */

@Service
public class WCXSurveyBizImpl implements IWCXSurveyBiz{

	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao baseDao;
	@SuppressWarnings("unchecked")
	@Override
	public int addSurvey(Survey survey) {
		int result =this.baseDao.add(Survey.class, survey, "addSurvey");
		return result;
	}
	
}
