package com.elec.demo.model;

import org.apache.ibatis.type.Alias;

import java.util.List;


@Alias(value = "user")
public class UserModel {

	private int userid;
	private String u_zhanghao=null;
	private String u_mima=null;
	private int userinfoid;
	UserInfoModel userInfoModel;
	//账单表
	List<ReckoningRecoderModel> reckoningRecoderModelList;
	//银行产品
	List<BankProductModel>  bankProductModelLis;

	public UserInfoModel getUserInfoModel() {
		return userInfoModel;
	}

	public List<ReckoningRecoderModel> getReckoningRecoderModelList() {
		return reckoningRecoderModelList;
	}

	public void setReckoningRecoderModelList(List<ReckoningRecoderModel> reckoningRecoderModelList) {
		this.reckoningRecoderModelList = reckoningRecoderModelList;
	}

	public List<BankProductModel> getBankProductModelLis() {
		return bankProductModelLis;
	}

	public void setBankProductModelLis(List<BankProductModel> bankProductModelLis) {
		this.bankProductModelLis = bankProductModelLis;
	}

	public void setUserInfoModel(UserInfoModel userInfoModel) {
		this.userInfoModel = userInfoModel;
	}

	public int getUserinfoid() {
		return userinfoid;
	}

	public void setUserinfoid(int userinfoid) {
		this.userinfoid = userinfoid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getU_zhanghao() {
		return u_zhanghao;
	}

	public void setU_zhanghao(String u_zhanghao) {
		this.u_zhanghao = u_zhanghao;
	}

	public String getU_mima() {
		return u_mima;
	}

	public void setU_mima(String u_mima) {
		this.u_mima = u_mima;
	}
}
