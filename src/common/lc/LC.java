package common.lc;

/**
 *
 * @author User
 */
public class LC {
    private String serial, merchant, time, date, status;

    public LC(String serial, String merchant, String time, String date, String status) {
        this.serial = serial;
        this.merchant = merchant;
        this.time = time;
        this.date = date;
        this.status = status;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
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
        return "LC{" + "serial=" + serial + ", merchant=" + merchant + ", time=" + time + ", date=" + date + ", status=" + status + '}';
    }
}
