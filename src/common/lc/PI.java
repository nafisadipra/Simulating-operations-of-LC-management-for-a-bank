/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.lc;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PI {
    private String serial,customer,company,address,phone,email,merchant,time,date,total_amount,gmStatus,crStatus,compStatus,type;
    private ArrayList<Product>productList;

    public PI(String serial, String customer, String company, String address, String phone, String email, String merchant, String time, String date, String total_amount, String gmStatus, String crStatus, String compStatus, String type, ArrayList<Product> productList) {
        this.serial = serial;
        this.customer = customer;
        this.company = company;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.merchant = merchant;
        this.time = time;
        this.date = date;
        this.total_amount = total_amount;
        this.gmStatus = gmStatus;
        this.crStatus = crStatus;
        this.compStatus = compStatus;
        this.type = type;
        this.productList = productList;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getGmStatus() {
        return gmStatus;
    }

    public void setGmStatus(String gmStatus) {
        this.gmStatus = gmStatus;
    }

    public String getCrStatus() {
        return crStatus;
    }

    public void setCrStatus(String crStatus) {
        this.crStatus = crStatus;
    }

    public String getCompStatus() {
        return compStatus;
    }

    public void setCompStatus(String compStatus) {
        this.compStatus = compStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "PI{" + "serial=" + serial + ", customer=" + customer + ", company=" + company + ", address=" + address + ", phone=" + phone + ", email=" + email + ", merchant=" + merchant + ", time=" + time + ", date=" + date + ", total_amount=" + total_amount + ", gmStatus=" + gmStatus + ", crStatus=" + crStatus + ", compStatus=" + compStatus + ", type=" + type + ", productList=" + productList + '}';
    }
    

   

    
    

}
