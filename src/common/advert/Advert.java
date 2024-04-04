package common.advert;

/**
 *
 * @author Muyeed
 */
public class Advert {
    private String product;
    private String brief;
    private String status;
    private String from;
    private String state;

    public Advert(String product, String brief, String status, String from, String state) {
        this.product = product;
        this.brief = brief;
        this.status = status;
        this.from = from;
        this.state = state;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Advert{" + "product=" + product + ", brief=" + brief + ", status=" + status + ", from=" + from + ", state=" + state + '}';
    }

}
