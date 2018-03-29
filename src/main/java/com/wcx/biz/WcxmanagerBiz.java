package com.wcx.biz;

import java.util.Map;

import com.wcx.bean.Manager;

public interface WcxmanagerBiz {
	/**
	 * 会员登录
	 * @param wcxmname
	 * @param wcxmpwd
	 * @return
	 */
	public Manager managerLogin(String wcxmname, String wcxmpwd);
	
	/**
	 * 分页查询
	 * @return
	 */
	public Map<String, Object> manfindByPage(int pageNo,int pageSize);

	/**
	 * 添加管理员
	 * @param manager
	 * @return
	 */
	public int addManager(Manager manager);
	
	/**
	 * 删除管理员
	 * @param wcxmid
	 * @return
	 */
	public Integer deleteManager(Integer ids);
}
