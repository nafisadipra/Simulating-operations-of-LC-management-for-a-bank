package common.message;

/**
 *
 * @Muyeed
 */
public class Message {
    private String data;
    private String user;
    private String time;
    private String date;
    private String subject;
    private String attachment;

    public Message(String data, String user, String time, String date, String subject, String attachment) {
        this.data = data;
        this.user = user;
        this.time = time;
        this.date = date;
        this.subject = subject;
        this.attachment = attachment;
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

    public String getSubject() {
        return subject;
    }

    public String getAttachment() {
        return attachment;
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

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Message{" + "data=" + data + ", user=" + user + ", time=" + time + ", date=" + date + ", subject=" + subject + ", attachment=" + attachment + '}';
    }
    
}
