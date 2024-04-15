package common.lc;

/**
 *
 * @author Muyeed
 */
public class Transaction {
    String id, sender, reciever, time, date, status;

    public Transaction(String id, String sender, String reciever, String time, String date, String status) {
        this.id = id;
        this.sender = sender;
        this.reciever = reciever;
        this.time = time;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", sender=" + sender + ", reciever=" + reciever + ", time=" + time + ", date=" + date + ", status=" + status + '}';
    }
    
}
