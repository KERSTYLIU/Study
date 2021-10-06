package com.elec.demo.model;


import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias(value = "electric")
public class ElectricModel {


	private int eid;
	private String ename;

	//	@JsonBackReference
	private UserModel userModel;
	private List<KindModel> kind;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public List<KindModel> getKind() {
		return kind;
	}

	public void setKind(List<KindModel> kind) {
		this.kind = kind;
	}
}
