package com.elec.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.ibatis.type.Alias;


import java.util.List;

@Alias(value = "kind")
public class KindModel {


	private int kid;
	private String kname;
	@JsonBackReference
	private List<ElectricModel> electric;

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public List<ElectricModel> getElectric() {
		return electric;
	}

	public void setElectric(List<ElectricModel> electric) {
		this.electric = electric;
	}
}
