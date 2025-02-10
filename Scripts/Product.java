package Scripts;

public class Product{
    private String name;
    private int quantity;
    private int product_id;

    Product(int id){
        product_id = id;
    } 

    Product(int id, String name, int quantity){
        this(id);
        SetQuantity(quantity);
        SetName(name);
    }


    public void AddQuantity(int amount){
        if (amount <= 0)
            System.out.println("Please provide positive amount for addition.");

        quantity += amount;
    }

    public void SubQuantity(int amount){
        if (amount <= 0)
            System.out.println("Please provide positive amount for subtraction.");

        quantity -= amount;
    }

    public String PrintInformation(){
        return (this.GetProductId() + ": " + this.GetName() + " (" + this.GetQuantity() + ")");
    }

    // setters

    public void SetName(String name){
        this.name = name;
    }

    public void SetQuantity(int quantity){
        this.quantity = quantity;
    }


    // getters

    public int GetId(){
        return product_id;
    }

    public String GetName(){
        return name;
    }

    public int GetQuantity(){
        return quantity;
    }

    public int GetProductId(){
        return product_id;
    }


}