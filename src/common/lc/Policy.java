package common.lc;

/**
 *
 * @author ishrak
 */
public class Policy {
    private String user;
    private String brief;
    private String time;
    private String date;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
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

    public Policy(String user, String brief, String time, String date) {
        this.user = user;
        this.brief = brief;
        this.time = time;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Policy{" + "user=" + user + ", brief=" + brief + ", time=" + time + ", date=" + date + '}';
    }
    
}
