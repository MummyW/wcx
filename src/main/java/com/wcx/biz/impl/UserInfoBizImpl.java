package com.wcx.biz.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcx.bean.UserInfo;
import com.wcx.biz.IUserInfoBiz;
import com.wcx.dao.BaseDao;
import com.wcx.util.MD5Encryption;
import com.wcx.util.StringUtil;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class UserInfoBizImpl implements IUserInfoBiz{
	@Autowired
	private BaseDao baseDao; 	//使用一个泛型的实体类，可以直接用它来当作数据层的类
	
	@Override
	public UserInfo userInfoLogin(String uname, String pwd) {
		if(StringUtil.isNull(uname,pwd)){
			return null;
		}else{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("uname", uname);
			map.put("pwd", pwd);
			System.out.println(map);
			return (UserInfo)this.baseDao.find(UserInfo.class, map, "userLogin");
		}
	}

	@Override
	public int userReg(UserInfo userInfo) {
		System.out.println("注册"+userInfo);
		if(StringUtil.isNull(userInfo.getWcxuname(),userInfo.getWcxupwd(),userInfo.getWcxuemail()   )){
			return 0;
		}else{
			//密码加密
			userInfo.setWcxupwd(MD5Encryption.createPassword(userInfo.getWcxupwd()));
			return this.baseDao.add(UserInfo.class, userInfo, "userInfoReg");
		}
	}
	
}
