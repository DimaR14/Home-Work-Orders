package Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class OrdersDAOclass implements OrdersDAO {
    private final Connection conn;

    public OrdersDAOclass(Connection conn){this.conn = conn;}

    @Override
    public String toString() {
        return "OrdersDAOclass{}";
    }

    @Override
    public void addOrder(int clientId,String productName,int quantity, int price) {
        try{
            try(PreparedStatement st = conn.prepareStatement("INSERT INTO orders (client_id,product_name,quantity,order_price) VALUE (?,?,?,?)")){
                st.setInt(1,clientId);
                st.setString(2,productName);
                st.setInt(3,quantity);
                st.setInt(4,price*quantity);
                st.executeUpdate();
            }
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }


}
