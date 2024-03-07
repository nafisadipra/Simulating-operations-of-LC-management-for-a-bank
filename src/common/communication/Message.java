/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.communication;

/**
 *
 * @author User
 */
public class Message {
    private String data;
    private String user;
    private String time;
    private String date;

    public Message(String data, String user, String time, String date) {
        this.data = data;
        this.user = user;
        this.time = time;
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public String getUser() {
        return user;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" + "data=" + data + ", user=" + user + ", time=" + time + ", date=" + date + '}';
    }
    
}
