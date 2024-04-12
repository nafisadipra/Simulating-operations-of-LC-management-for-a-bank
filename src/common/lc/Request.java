/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.lc;

/**
 *
 * @author User
 */
public class Request {
    private String type,email,date,time;

    public Request(String type, String email, String date, String time) {
        this.type = type;
        this.email = email;
        this.date = date;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Request{" + "type=" + type + ", email=" + email + ", date=" + date + ", time=" + time + '}';
    }
    
}
