package Scripts;

import java.util.List;

public interface IProductRepository {
    boolean createProduct(Product product);
    Product getProduct(int id);
    List<Product> getAllProducts();
}
