package Scripts

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
        this.quantity = quantity;
        this.name = name;
    }


    public void AddQuantity(int amount){
        if (amount <= 0)
            System.out.println("Please provide positive amount for addition.")

        quantity += amount;
    }

    public void SubQuantity(int amount){
        if (amount <= 0)
            System.out.println("Please provide positive amount for subtraction.")

        quantity -= amount
    }

    // setters

    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }


    // getters

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }


}