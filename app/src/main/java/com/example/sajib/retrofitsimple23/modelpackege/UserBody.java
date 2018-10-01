package com.example.sajib.retrofitsimple23.modelpackege;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserBody {
    @SerializedName("cust_first_name")
    @Expose
    private String custFirstName;
    @SerializedName("cust_username")
    @Expose
    private String custUsername;
    @SerializedName("cust_phone")
    @Expose
    private String custPhone;
    @SerializedName("cust_password")
    @Expose
    private String custPassword;
    @SerializedName("address")
    @Expose
    private String address;

    public UserBody(String custFirstName, String custUsername,
                    String custPhone, String custPassword, String address) {
        this.custFirstName = custFirstName;
        this.custUsername = custUsername;
        this.custPhone = custPhone;
        this.custPassword = custPassword;
        this.address = address;
    }

    public UserBody() {
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }
    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
