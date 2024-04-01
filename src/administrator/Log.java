package administrator;

/**
 *
 * @author Muyeed
 */
public class Log {
    private String type;
    private String email;
    private String time;
    private String date;

    public Log(String type, String email, String time, String date) {
        this.type = type;
        this.email = email;
        this.time = time;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Log{" + "type=" + type + ", email=" + email + ", time=" + time + ", date=" + date + '}';
    }

}
