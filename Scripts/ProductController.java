package Scripts;

import java.util.List;

public class ProductController {
    private final IProductRepository repo;

    public ProductController(IProductRepository repo) {
        this.repo = repo;
    }

    public String CreateProduct(int id, String Name, int quantity) {
        Product product = new Product(id, Name, quantity);
        boolean created = repo.createProduct(product);

        return (created ? "Product was created!" : "Product creating was failed!");
    }

    public String GetProduct(int id) {
        Product product = repo.getProduct(id);

        return (product != null ? product.PrintInformation() : "Product not found!");
    }

    public String getAllUProducts() {
        List<Product> products = repo.getAllProducts();

        String response = "";
        for (Product product : products) {
            response += '\n';
            response += product.PrintInformation();
        }

        return response;
    }
}
