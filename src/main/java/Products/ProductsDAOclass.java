package Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAOclass implements ProductsDAO {
    private final Connection conn;
    private List<Products> res = new ArrayList();

    public ProductsDAOclass(Connection conn) { this.conn = conn;}


    @Override
    public List<Products> getAll() {
        try{
            try(Statement st = conn.createStatement()){
                try(ResultSet rs = st.executeQuery("SELECT * FROM products")){
                    while(rs.next()){
                        Products pr = new Products();
                        pr.setProductName(rs.getString(1));
                        pr.setPrice(rs.getInt(2));
                        pr.setQuantity(rs.getInt(3));
                        res.add(pr);
                    }
                }
            }
            return res;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void changeQuantity(int quan,String pn) {
        try {
            try (PreparedStatement st = conn.prepareStatement("UPDATE products SET quantity=" + "'" + quan + "' " +
                    "WHERE product_name=" + "'" + pn + "'")) {
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(Products p : res){
            s+= "\n"+ p.toString();
        }
        return "Products:"+ s;
    }
}
