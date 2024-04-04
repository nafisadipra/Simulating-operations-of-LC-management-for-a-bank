/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.device;

/**
 *
 * @author Muyeed
 */
public class Log {
    private String user, email, ip, time, date;

    public Log(String user, String email, String ip, String time, String date) {
        this.user = user;
        this.email = email;
        this.ip = ip;
        this.time = time;
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    @Override
    public String toString() {
        return "Log{" + "user=" + user + ", email=" + email + ", ip=" + ip + ", time=" + time + ", date=" + date + '}';
    }

}
