package common.sandwich;

/**
 *
 * @author Muyeed
 */
public class Sandwich {
    private String item;

    public Sandwich(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Sandwhich{" + "item=" + item + '}';
    }
    
}
