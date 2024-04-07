package common.feedback;

/**
 *
 * @author Muyeed
 */
public class Feedback {
    private String subject, message, time, date;

    public Feedback(String subject, String message, String time, String date) {
        this.subject = subject;
        this.message = message;
        this.time = time;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        return "Feedback{" + "subject=" + subject + ", message=" + message + ", time=" + time + ", date=" + date + '}';
    }
    
}
