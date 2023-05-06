package com.edokan.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	private int pId;
	private String pName;
	private String pType;
	private String pSalerId;

	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getpSalerId() {
		return pSalerId;
	}
	public void setpSalerId(String pSalerId) {
		this.pSalerId = pSalerId;
	}

}
