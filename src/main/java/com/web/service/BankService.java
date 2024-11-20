package com.web.service;

import java.util.List;

import com.web.model.Bank;

public interface BankService {

	public Bank saveBank(Bank bank);
	public Bank getBank(long acno,String name, String psw);
	public Bank deposit(long acno,String name, String psw,double amt);
	public Bank withdraw(long acno,String name, String psw,double amt);
	public void transfer(long acNo, String name, String psw, long tacNo, double amt);
	public void closeAccount(long acNo, String name, String psw);
	
}
