package com.wcx.bean;

import java.io.Serializable;

/**
 * 调查表
 * @author JJF
 *
 */
public class Survey implements Serializable{
	private static final long serialVersionUID = 6312079692606098003L;
private int wcxsid;        			//调查表id
	 private int wcxuid;			//用户的用户ID
     private String wcxsname;      //调查表名
     private int wcxtid;           //模板分类id
     private String wcxintroduce;  //简介
     private String wcxpublishdate;     //发表日期
     private String wcxfinishdate;             //截止日期
     private int status;            //状态 
	public int getWcxsid() {
		return wcxsid;
	}
	public void setWcxsid(int wcxsid) {
		this.wcxsid = wcxsid;
	}
	public int getWcxuid() {
		return wcxuid;
	}
	public void setWcxuid(int wcxuid) {
		this.wcxuid = wcxuid;
	}
	public String getWcxsname() {
		return wcxsname;
	}
	public void setWcxsname(String wcxsname) {
		this.wcxsname = wcxsname;
	}
	public int getWcxtid() {
		return wcxtid;
	}
	public void setWcxtid(int wcxtid) {
		this.wcxtid = wcxtid;
	}
	public String getWcxintroduce() {
		return wcxintroduce;
	}
	public void setWcxintroduce(String wcxintroduce) {
		this.wcxintroduce = wcxintroduce;
	}
	public String getWcxpublishdate() {
		return wcxpublishdate;
	}
	public void setWcxpublishdate(String wcxpublishdate) {
		this.wcxpublishdate = wcxpublishdate;
	}
	public String getWcxfinishdate() {
		return wcxfinishdate;
	}
	public void setWcxfinishdate(String wcxfinishdate) {
		this.wcxfinishdate = wcxfinishdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Survey [wcxsid=" + wcxsid + ", wcxuid=" + wcxuid
				+ ", wcxsname=" + wcxsname + ", wcxtid=" + wcxtid
				+ ", wcxintroduce=" + wcxintroduce + ", wcxpublishdate="
				+ wcxpublishdate + ", wcxfinishdate=" + wcxfinishdate
				+ ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + status;
		result = prime * result
				+ ((wcxfinishdate == null) ? 0 : wcxfinishdate.hashCode());
		result = prime * result
				+ ((wcxintroduce == null) ? 0 : wcxintroduce.hashCode());
		result = prime * result
				+ ((wcxpublishdate == null) ? 0 : wcxpublishdate.hashCode());
		result = prime * result + wcxsid;
		result = prime * result
				+ ((wcxsname == null) ? 0 : wcxsname.hashCode());
		result = prime * result + wcxtid;
		result = prime * result + wcxuid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		if (status != other.status)
			return false;
		if (wcxfinishdate == null) {
			if (other.wcxfinishdate != null)
				return false;
		} else if (!wcxfinishdate.equals(other.wcxfinishdate))
			return false;
		if (wcxintroduce == null) {
			if (other.wcxintroduce != null)
				return false;
		} else if (!wcxintroduce.equals(other.wcxintroduce))
			return false;
		if (wcxpublishdate == null) {
			if (other.wcxpublishdate != null)
				return false;
		} else if (!wcxpublishdate.equals(other.wcxpublishdate))
			return false;
		if (wcxsid != other.wcxsid)
			return false;
		if (wcxsname == null) {
			if (other.wcxsname != null)
				return false;
		} else if (!wcxsname.equals(other.wcxsname))
			return false;
		if (wcxtid != other.wcxtid)
			return false;
		if (wcxuid != other.wcxuid)
			return false;
		return true;
	}
     
	
}
