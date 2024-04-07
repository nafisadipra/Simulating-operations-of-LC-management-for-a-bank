/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.lc;

/**
 *
 * @author User
 */
public class Product {
    private String serial,product,quantity,price,amount,exporter;

    public Product(String serial, String product, String quantity, String price, String exporter) {
        this.serial = serial;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
       
        this.exporter = exporter;
    }

    public String getSerial() {
        return serial;
    }

    public String getProduct() {
        return product;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getAmount() {
        double a = Double.parseDouble(getPrice().substring(1));
        double b = Double.parseDouble(getQuantity());
        return Double.toString(a*b);
    }

    public String getExporter() {
        return exporter;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setExporter(String exporter) {
        this.exporter = exporter;
    }

    @Override
    public String toString() {
        return "Product{" + "serial=" + serial + ", product=" + product + ", quantity=" + quantity + ", price=" + price + ", amount=" + amount + ", exporter=" + exporter + '}';
    }
    
}
