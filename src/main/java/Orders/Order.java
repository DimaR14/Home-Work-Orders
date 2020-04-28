package Orders;

import Clients.Id;

public class Order {
    @Id
    private int orderId;
    private int clientId;
    private String product_name;
    private int quantity;
    private int orderPrice;

    public Order(){}

    public Order(int orderId, int clientId, String product_name, int quantity, int orderPrice) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.product_name = product_name;
        this.quantity = quantity;
        this.orderPrice = orderPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", product_name='" + product_name + '\'' +
                ", quantity=" + quantity +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
