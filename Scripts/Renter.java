package Scripts;

import java.util.ArrayList;
import java.util.List;

public class Renter extends User{
    private List<Product> products = new ArrayList<Product>();

    Renter(int id) {
        super(id);
    }

    Renter(int id, String name, String phoneNumber){
        super(id, name, phoneNumber);
    }

    Renter(int id, String name, String phoneNumber, List<Product> products){
        super(id, name, phoneNumber);
        SetProducts(products);
    }

    public void AddProduct(Product product){
        products.add(product);
    }

    public void RemoveProduct(Product product){
        products.remove(product);
    }

    public void PrintProducts(){
        for(Product product : products){
            product.PrintInformation();
        }
    }

    @Override
    public String GetInformation(){
        return (this.GetId() + ": " + this.GetName() + " -> " + this.GetPhoneNumber());
    }

    public void ListProducts(){
        for(Product product : products){
            product.PrintInformation();
        }
    }

    // getters

    public List<Product> GetProducts(){
        return products;
    }

    //setters

    public void SetProducts(List<Product> products){
        this.products = products;
    }

}
