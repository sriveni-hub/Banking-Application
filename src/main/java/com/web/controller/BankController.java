package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.model.Bank;
import com.web.service.BankServiceImp;

@Controller
public class BankController {

    @Autowired
    private BankServiceImp service;

    @RequestMapping("/")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/newAc")
    public String newAcForm() {
        return "acform";
    }

    @RequestMapping("/submit")
    public String submit(Bank bank, Model model) {
        Bank saveOneBank = service.saveBank(bank);
        return "success";
    }

    @RequestMapping("/balance")
    public String balanceForm() {
        return "bform";
    }

    @RequestMapping("/viewBalance")
    public String viewBalance(@RequestParam long acNo, @RequestParam String name, @RequestParam String psw, Model model) {
        
            Bank bank = service.getBank(acNo, name, psw);
            model.addAttribute("bank", bank);
            return "viewdata";
       
    }
   

    @RequestMapping("/dp")
    public String depositForm() {
        return "dpform";
    }
    @RequestMapping("/deposit")
    public String deposit(@RequestParam long acNo, @RequestParam String name, @RequestParam String psw, @RequestParam double amt, ModelMap model) {
        
            Bank bank = service.deposit(acNo, name, psw, amt);
            model.addAttribute("message", "Deposit successful. New balance: " + bank.getAmt());
            return "dpresult";
        
        }
    @RequestMapping("/wdw")
    public String withdrawForm() {
        return "withdrawform";
    }
    @RequestMapping("/withdraw")
      public String withdraw(@RequestParam long acNo, @RequestParam String name, @RequestParam String psw, @RequestParam double amt, ModelMap model) {
          
              Bank bank = service.withdraw(acNo, name, psw, amt);
              model.addAttribute("message", "Withdrawal successful! New balance: " + bank.getAmt());
              return "wdwresult";
          
      }



    @RequestMapping("/tf")
    public String transferForm() {
        return "transferform";
    }
    @PostMapping("/transfer")
    public String transfer(@RequestParam long acNo, @RequestParam String name, @RequestParam String psw, @RequestParam long tacNo, @RequestParam double amt, ModelMap model) {
      
            service.transfer(acNo, name, psw, tacNo, amt);
            Bank senderBank = service.getBank(acNo, name, psw);
            model.addAttribute("message", "Transfer successful! New balance: " + senderBank.getAmt());
            return "tfresult";
       
    }


   

    @RequestMapping("/closeAc")
    public String closeAccount() {
        return "closeform";
    }
    @RequestMapping("/closeAccount")
    public String closeAccount(@RequestParam long acNo, @RequestParam String name, @RequestParam String psw, ModelMap model) {
       
            service.closeAccount(acNo, name, psw);
            model.addAttribute("message", "Account closed successfully.");
            return "closeresult";
       
    }
    @RequestMapping("/ab")
    public String aboutUs() {
        return "about";
    }
}
