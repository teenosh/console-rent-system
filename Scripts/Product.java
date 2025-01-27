package Scripts;

public final class Product{
    private String name;
    private int quantity;
    private int product_id;
    private static int id_gen = 1;

    Product(){
        product_id = id_gen++;
    } 

    Product(String name, int quantity){
        this();
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

    public void PrintInformation(){
        System.out.println(this.GetProductId() + ": " + this.GetName() + " (" + this.GetQuantity() + ")");
    }

    // setters

    public void SetName(String name){
        this.name = name;
    }

    public void SetQuantity(int quantity){
        this.quantity = quantity;
    }


    // getters

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