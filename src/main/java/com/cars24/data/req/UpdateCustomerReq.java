package com.cars24.data.req;

public class UpdateCustomerReq {
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String curmail;
    private String curphone;

    @Override
    public String toString() {
        return "UpdateCustomerReq{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", address='" + address + '\'' +
                ", curmail='" + curmail + '\'' +
                ", curphone='" + curphone + '\'' +
                '}';
    }

    public String getCurmail() {
        return curmail;
    }

    public void setCurmail(String curmail) {
        this.curmail = curmail;
    }

    public String getCurphone() {
        return curphone;
    }

    public void setCurphone(String curphone) {
        this.curphone = curphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
