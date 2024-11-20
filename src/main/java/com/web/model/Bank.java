package com.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {
	@Id
	private long acNo;
	private String name;
	private String psw;
	private String cpsw;
	private double amt;
	private String addr;
	private String mobile;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(long acNo, String name, String psw, String cpsw, double amt, String addr, String mobile) {
		super();
		this.acNo = acNo;
		this.name = name;
		this.psw = psw;
		this.cpsw = cpsw;
		this.amt = amt;
		this.addr = addr;
		this.mobile = mobile;
	}

	public long getAcNo() {
		return acNo;
	}

	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getCpsw() {
		return cpsw;
	}

	public void setCpsw(String cpsw) {
		this.cpsw = cpsw;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Bank [acNo=" + acNo + ", name=" + name + ", psw=" + psw + ", cpsw=" + cpsw + ", amt=" + amt + ", addr="
				+ addr + ", mobile=" + mobile + "]";
	}
	
}
