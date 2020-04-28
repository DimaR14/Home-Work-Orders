package Products;

import java.util.List;

public interface ProductsDAO {
    List<Products> getAll();
    void changeQuantity(int quantity,String pn);
}
