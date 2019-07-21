package com.example.cooperativesociety.Model;

import android.graphics.Bitmap;

public class MembersModelClass {

    private String imageToString,username,email,donate,dateOfBirth,phone;

    public MembersModelClass() {

    }





    public MembersModelClass(String imageToString, String username, String email, String donate,String dathOfBarth,String phone) {
        this.imageToString = imageToString;
        this.username = username;
        this.email = email;
        this.donate = donate;
        this.dateOfBirth = dathOfBarth;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getDonate() {
        return donate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageToString() {
        return imageToString;
    }

    public void setImageToString(String imageToString) {
        this.imageToString = imageToString;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDonate(String donate) {
        this.donate = donate;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
