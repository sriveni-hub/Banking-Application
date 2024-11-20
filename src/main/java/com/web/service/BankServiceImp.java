package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Bank;
import com.web.repo.BankRepo;
@Service
public class BankServiceImp implements BankService {
	@Autowired private BankRepo repo;
	@Override
	public Bank saveBank(Bank bank) {
		
		 if (bank.getPsw().equals(bank.getCpsw())) {
	            return repo.save(bank);
	        } 
		 else {
	            throw new IllegalArgumentException("Passwords do not match");
	        }
	    }
	
	@Override
	public Bank getBank(long acNo, String name, String psw) {
	    Bank bank = repo.findById(acNo).orElse(null);
	    if (bank != null && bank.getName().equals(name) && bank.getPsw().equals(psw)) {
	        return bank;
	    } else {
	        throw new IllegalArgumentException("Account does not exist or invalid credentials.");
	    }
	}
	 @Override
	    public Bank deposit(long acNo, String name, String psw, double amt) {
	        Bank bank = getBank(acNo, name, psw);
	        if (bank != null) {
	            bank.setAmt(bank.getAmt() +amt);
	            return repo.save(bank);
	        } else {
	            throw new IllegalArgumentException("Invalid account or credentials.");
	        }
	    }
	 @Override
	 public Bank withdraw(long acNo, String name, String psw, double amt) {
	     Bank bank = getBank(acNo, name, psw);
	     if (bank.getAmt() >= amt) {
	         bank.setAmt(bank.getAmt() - amt);
	         return repo.save(bank);
	     } else {
	         throw new IllegalArgumentException("Insufficient funds.");
	     }
	 }
	 @Override
	 public void transfer(long acNo, String name, String psw, long tacNo, double amt) {
	     Bank senderBank = getBank(acNo, name, psw);
	     Bank receiverBank = repo.findById(tacNo).orElse(null);

	     if (senderBank != null && senderBank.getAmt() >= amt) {
	         if (receiverBank != null) {
	             senderBank.setAmt(senderBank.getAmt() - amt);
	             receiverBank.setAmt(receiverBank.getAmt() + amt);
	             repo.save(senderBank);
	             repo.save(receiverBank);
	         } else {
	             throw new IllegalArgumentException("Receiver account not found.");
	         }
	     } else {
	         throw new IllegalArgumentException("Insufficient funds or invalid sender account details.");
	     }
	 }

	 @Override
	 public void closeAccount(long acNo, String name, String psw) {
	     Bank bank = getBank(acNo, name, psw);
	     if (bank != null) {
	         repo.deleteById(acNo);
	     } else {
	         throw new IllegalArgumentException("Invalid account details.");
	     }
	 }
	}
