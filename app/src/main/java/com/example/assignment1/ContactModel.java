package com.example.assignment1;

import android.location.Address;

public class ContactModel {
    int img;
    String Name,Age,Address;

    public ContactModel(int img, String Name, String Age, String Address){
        this.Name = Name;
        this.Age = Age;
        this.Address= Address;
        this.img = img;

    }

    public ContactModel(String Name,String Age,String Address ){
        this.Name= Name;
        this.Age=Age;
        this.Address= Address;
    }



}
