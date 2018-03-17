package com.wcx.biz;

import com.wcx.bean.Manager;

public interface IWcxmanagerBiz {
	/**
	 * 会员登录
	 * @param m
	 * @return
	 */
	public Manager managerLogin(String wcxmname, String wcxmpwd);
}
