package com.wcx.biz;

import com.wcx.bean.UserInfo;

public interface IUserInfoBiz {
	
	public UserInfo userInfoLogin(String uname,String pwd);
}
