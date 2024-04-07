package common.advertisement;

/**
 *
 * @author Muyeed
 */
public class Advertisement {
    private String product;
    private String brief;
    private String status;
    private String merchant;

    public Advertisement(String product, String brief, String status, String merchant) {
        this.product = product;
        this.brief = brief;
        this.status = status;
        this.merchant = merchant;
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

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "Advert{" + "product=" + product + ", brief=" + brief + ", status=" + status + ", merchant=" + merchant + '}';
    }
    
}
