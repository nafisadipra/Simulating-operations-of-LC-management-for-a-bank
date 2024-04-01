/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.lc;

/**
 *
 * @author User
 */
public class PI {
    private String serial, customer, company, address, phone, email, importer, quantity, product, time, date;

    public PI(String serial, String customer, String company, String address, String phone, String email, String importer, String quantity, String product, String time, String date) {
        this.serial = serial;
        this.customer = customer;
        this.company = company;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.importer = importer;
        this.quantity = quantity;
        this.product = product;
        this.time = time;
        this.date = date;
    }

    public String getSerial() {
        return serial;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getImporter() {
        return importer;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getProduct() {
        return product;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PI{" + "serial=" + serial + ", customer=" + customer + ", company=" + company + ", address=" + address + ", phone=" + phone + ", email=" + email + ", importer=" + importer + ", quantity=" + quantity + ", product=" + product + ", time=" + time + ", date=" + date + '}';
    }
    
}
