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
    private String serial,product,quantity,perPrice,amount,importer;

    public Product(String serial, String product, String quantity, String perPrice, String amount, String importer) {
        this.serial = serial;
        this.product = product;
        this.quantity = quantity;
        this.perPrice = perPrice;
        this.amount = amount;
        this.importer = importer;
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

    public String getPerPrice() {
        return perPrice;
    }

    public String getAmount() {
        return amount;
    }

    public String getImporter() {
        return importer;
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

    public void setPerPrice(String perPrice) {
        this.perPrice = perPrice;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }

    @Override
    public String toString() {
        return "Product{" + "serial=" + serial + ", product=" + product + ", quantity=" + quantity + ", perPrice=" + perPrice + ", amount=" + amount + ", importer=" + importer + '}';
    }
    
}
