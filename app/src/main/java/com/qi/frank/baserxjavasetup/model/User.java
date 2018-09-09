package com.qi.frank.baserxjavasetup.model;

import org.parceler.Parcel;

@Parcel
public class User {

    String id;
    String access_token;

    String email;
    String first_name;
    String last_name;
    String gender;
    String dob;
    String post_code;
    String phone_number;
    String mobile_number;
    String address;
    String suburb;
    String state;
    String country;

    public User() {
    }

    public User(User newUser) {
        this.id = newUser.getId();
        this.access_token = newUser.access_token;
        this.email = newUser.getEmail();
        this.first_name = newUser.getFirst_name();
        this.last_name = newUser.getLast_name();
        this.gender = newUser.getGender();
        this.dob = newUser.getDob();
        this.post_code = newUser.getPost_code();
        this.phone_number = newUser.getPhone_number();
        this.mobile_number = newUser.getMobile_number();
        this.address = newUser.getAddress();
        this.suburb = newUser.getSuburb();
        this.state = newUser.getState();
        this.country = newUser.getCountry();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullName() {
        return getFirst_name() + " " + getLast_name();
    }
}
