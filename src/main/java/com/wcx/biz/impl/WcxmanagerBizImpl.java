package com.wcx.biz.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcx.bean.Manager;
import com.wcx.biz.IWcxmanagerBiz;
import com.wcx.dao.BaseDao;
import com.wcx.util.MD5Encryption;
import com.wcx.util.StringUtil;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class WcxmanagerBizImpl implements IWcxmanagerBiz{
	@Autowired
	private BaseDao baseDao;

	/**
	 * 会员登录
	 */
	@Override
	public Manager managerLogin(String wcxmname, String wcxmpwd) {
		System.out.println(wcxmname);
		if(StringUtil.isNull(wcxmname,wcxmpwd)){                                        //判断字符串是否为空
			return null;
		}else{
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("wcxmname", wcxmname);
			//wcxmpwd=MD5Encryption.createPassword(wcxmpwd);
			map.put("wcxmpwd", wcxmpwd);
			System.out.println(map);

			return (Manager) this.baseDao.find(Manager.class, map,"managerLogin");
		}
	}
	

}
