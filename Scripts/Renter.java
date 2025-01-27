package Scripts;

import java.util.ArrayList;
import java.util.List;

public final class Renter extends User{
    private List<Product> products = new ArrayList<Product>();

    Renter() {
        super();
    }

    Renter(String name, String phoneNumber){
        super(name, phoneNumber);
    }

    Renter(String name, String phoneNumber, List<Product> products){
        super(name, phoneNumber);
        SetProducts(products);
    }

    public void AddProduct(Product product){
        products.add(product);
    }

    public void RemoveProduct(Product product){
        products.remove(product);
    }

    public void GetInformation(){
        System.out.println(this.GetId() + ": " + this.GetName() + " [" + this.GetPhoneNumber() + "]");
    }

    public void PrintProducts(){
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
