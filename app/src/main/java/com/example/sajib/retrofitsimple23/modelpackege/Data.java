package com.example.sajib.retrofitsimple23.modelpackege;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("cust_userid")
    @Expose
    private Integer custUserid;
    @SerializedName("cust_first_name")
    @Expose
    private String custFirstName;
    @SerializedName("cust_last_name")
    @Expose
    private String custLastName;
    @SerializedName("cust_username")
    @Expose
    private String custUsername;
    @SerializedName("cust_email")
    @Expose
    private String custEmail;
    @SerializedName("cust_phone")
    @Expose
    private String custPhone;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("auth_key")
    @Expose
    private String authKey;

    public Integer getCustUserid() {
        return custUserid;
    }

    public void setCustUserid(Integer custUserid) {
        this.custUserid = custUserid;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
}
