package br.ufrn.imd.models;

import org.jetbrains.annotations.NotNull;

public class BankAccount {
    private long accountNumber;
    private int agency;
    private double balance;

    public BankAccount() {
        this.accountNumber = 0;
        this.agency = 0;
        this.balance = 0;
    }

    public BankAccount(long accountNumber, int agency, double balance) {
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.balance = balance;
    }

    public int getAgency() {
        return agency;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        if (value <= 0) throw new IllegalArgumentException();
        this.balance += value;
    }

    public void withdraw(double value){
        if(value <= 0) throw new IllegalArgumentException();
        else if (balance < value) throw new ArithmeticException();
        else {
        	balance -= value;
        }
    }

    public void transfer(BankAccount beneficiaryAccount, double value){
    	withdraw(value);
    	beneficiaryAccount.deposit(value);
    }
}
