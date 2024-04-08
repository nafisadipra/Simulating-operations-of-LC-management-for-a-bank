package common.feedback;

/**
 *
 * @author Muyeed
 */
public class Feedback {
    private String subject, message, user, email, time, date;

    public Feedback(String subject, String message, String user, String email, String time, String date) {
        this.subject = subject;
        this.message = message;
        this.user = user;
        this.email = email;
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
        return "Feedback{" + "subject=" + subject + ", message=" + message + ", user=" + user + ", email=" + email + ", time=" + time + ", date=" + date + '}';
    }
 
}
