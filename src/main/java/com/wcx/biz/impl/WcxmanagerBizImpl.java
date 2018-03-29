package com.wcx.biz.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcx.bean.Manager;
import com.wcx.bean.UserInfo;
import com.wcx.biz.WcxmanagerBiz;
import com.wcx.dao.BaseDao;
import com.wcx.util.StringUtil;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class WcxmanagerBizImpl implements WcxmanagerBiz{
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

	/**
	 * 分页查询
	 */
	@Override
	public Map<String, Object> manfindByPage(int pageNo, int pageSize) {
		Map<String, Object> map=new HashMap<String,Object>();
		Map<String, Object> map1=new HashMap<String,Object>();
		
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map1.put("total", this.baseDao.findFunc(Manager.class, "getCount").intValue());
		map1.put("rows", this.baseDao.findAll(Manager.class, map, "manfindByPage"));
		return map1;
	}

	/**
	 * 添加管理员
	 */
	@Override
	public int addManager(Manager manager) {
		return baseDao.add(Manager.class, manager, "addManager");
	}

	/**
	 * 删除管理员
	 */
	@Override
	public Integer deleteManager(Integer wcxmid) {
		System.out.println("wcxmid= "+wcxmid);
		return baseDao.delete(Manager.class, wcxmid, "deleteManager");
	}

}
