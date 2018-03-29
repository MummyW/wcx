package com.wcx.biz;

import java.util.Map;

import com.wcx.bean.UserInfo;

public interface IUserInfoBiz {
	
	/**
	 * 登录
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public UserInfo userInfoLogin(String uname,String pwd);
	
	/**
	 * 注册
	 * @param userInfo
	 * @return
	 */
	int userReg(UserInfo userInfo);
	
	/**
	 * 添加用户
	 * @param userInfo
	 * @return
	 */
	public int addUser(UserInfo userInfo);
	
	/**
	 * 删除用户
	 * @param wcxuid
	 * @return
	 */
	public Integer deleteUser(Integer wcxuid);
	
	
	/**
	 * 分页查询
	 * @return
	 */
	public  Map<String, Object> userfindByPage(int pageNo,int pageSize);
	
	/**
	 * 修改图片
	 * @param lid
	 * @param photo
	 * @return
	 */
	public int updateUPhoto(Integer wcxuid,String wcxuphoto);
}
