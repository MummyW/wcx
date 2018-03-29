package com.wcx.biz.impl;

import java.util.HashMap;
import java.util.List;
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
	
	/**
	 * 登录
	 */
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

	/**
	 * 注册
	 */
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

	/**
	 * 添加用户
	 */
	@Override
	public int addUser(UserInfo userInfo) {
		System.out.println(userInfo);
		return baseDao.add(UserInfo.class, userInfo, "addUser");
	}

	/**
	 * 分页查询
	 */
	@Override
	public Map<String, Object> userfindByPage(int pageNo, int pageSize) {
		Map<String, Object> map=new HashMap<String,Object>();
		Map<String, Object> map1=new HashMap<String,Object>();
		
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map1.put("total", this.baseDao.findFunc(UserInfo.class, "getCount").intValue());
		map1.put("rows", this.baseDao.findAll(UserInfo.class, map, "userfindByPage"));
		return map1;
	}
	
	/**
	 * 删除用户
	 */
	@Override
	public Integer deleteUser(Integer wcxuid) {
		System.out.println(wcxuid);
		return baseDao.delete(UserInfo.class, wcxuid, "deleteUser");
	}

	/**
	 * 修改图片
	 */
	@Override
	public int updateUPhoto(Integer wcxuid, String wcxuphoto) {
		if (StringUtil.isNull(wcxuphoto)) {
			return 0;
		}else{
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("wcxuid", wcxuid);
			map.put("photo", wcxuphoto);
			return this.baseDao.add(UserInfo.class, map, "updateUPhoto");
		}
	}

}
