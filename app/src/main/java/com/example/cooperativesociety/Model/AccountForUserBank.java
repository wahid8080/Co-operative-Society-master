package com.example.cooperativesociety.Model;

public class AccountForUserBank {

    private String userName,Pass,ConPass;

    public AccountForUserBank(String userName, String pass, String conPass) {
        this.userName = userName;
        Pass = pass;
        ConPass = conPass;
    }

    public AccountForUserBank() {
    }

    public AccountForUserBank(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getConPass() {
        return ConPass;
    }

    public void setConPass(String conPass) {
        ConPass = conPass;
    }
}
