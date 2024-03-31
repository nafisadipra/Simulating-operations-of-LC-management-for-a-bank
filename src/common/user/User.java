/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.user;

/**
 *
 * @author User
 */
public class User {
    private String name;
    private String passowrd;
    private String email;
    private String phone;
    private String address;
    private String dob;
    private String type;
    private String state;

    public User(String name, String passowrd, String email, String phone, String address, String dob, String type, String state) {
        this.name = name;
        this.passowrd = passowrd;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.type = type;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", passowrd=" + passowrd + ", email=" + email + ", phone=" + phone + ", address=" + address + ", dob=" + dob + ", type=" + type + ", state=" + state + '}';
    }
    
}
