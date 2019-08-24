/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BankCustomer;

/**
 *
 * @author Obaydah Mohamad
 */
public class CustomerDTO {
    private int id;
    private String fullname;
    private String accountNumber;
    private double balance;
    
    public CustomerDTO(BankCustomer bc){
        this.id =  bc.getId().intValue();
        this.fullname = bc.getFirstName() + " " + bc.getLastName();
        this.accountNumber = bc.getAccountNumber();
        this.balance = bc.getBalance();
    }
}
