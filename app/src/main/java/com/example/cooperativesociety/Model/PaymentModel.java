package com.example.cooperativesociety.Model;

public class PaymentModel {

    private int balance;
    private String referance;

    public PaymentModel() {
    }

    public PaymentModel(int balance, String referance) {
        this.balance = balance;
        this.referance = referance;
    }

    public PaymentModel(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }
}
