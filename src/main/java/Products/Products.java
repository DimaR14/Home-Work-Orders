package Products;

import Clients.Id;

public class Products {
    @Id
    private String productName;
    private  int price;
    private int quantity;

    public Products(){}

    public Products(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product: " +
               "\n"+"Name:      " + productName +
                "\n"+"Price:       " + price +
                "\n"+"Stock quantity: "+ quantity+
                "\n";
    }
}
