package com.example.cooperativesociety.Model;

public class UserInformation {

    private String email,nid,phone,username,imageToString,dateOfBirth,user;

    private int balance;


    public UserInformation(String email, String phone, String imageToString) {
        this.email = email;
        this.phone = phone;
        this.imageToString = imageToString;
    }

    public UserInformation(String email, String nid, String phone, String username, String imageToString, String dateOfBirth, String user) {
        this.email = email;
        this.nid = nid;
        this.phone = phone;
        this.username = username;
        this.imageToString = imageToString;
        this.dateOfBirth = dateOfBirth;
        this.user = user;
    }

    public UserInformation(int balance) {
        this.balance = balance;

    }

    public UserInformation() {

    }

    public String getEmail() {
        return email;
    }

    public String getNid() {
        return nid;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getImageToString() {
        return imageToString;
    }

    public int getBalance() {
        return balance;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUser() {
        return user;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setNid(String nid) {
        this.nid = nid;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImageToString(String imageToString) {
        this.imageToString = imageToString;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
