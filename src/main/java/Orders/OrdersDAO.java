package Orders;

public interface OrdersDAO {
    void addOrder(int clientId,String productName,int quantity, int price);
    String toString();

}
