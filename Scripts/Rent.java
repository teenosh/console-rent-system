package Scripts;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Rent{
    private User provider;
    private User customer;
    private Product product;
    private float rentTime;
    private String status; // Canceled, Pending, Ended
    private int rentId;
    private static int id_gen = 1;
    LocalDateTime rentStart;

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    Rent(){
        rentId = id_gen++;
    }

    Rent(User provider, User customer, float rentTime, String status, Product product){
        this();
        SetProvider(provider);
        SetCustomer(customer);
        SetRentTime(rentTime);
        SetStatus(status);
        SetProduct(product);
        rentStart = LocalDateTime.now();
    }


    public void ExtendTime(float amount){
        rentTime += amount;
    }

    public void PrintInformation(){
        System.out.println(this.GetRentId() + ": " + GetProduct().GetName() + " (" + GetProduct().GetQuantity() + ") from "+ GetProvider().GetName() + " to " + GetCustomer().GetName() + " for " + this.GetRentTime() + " hours. Status - " + this.GetStatus() + "(until ");
    }

    // setters

    public void SetProvider(User provider){
        this.provider = provider;
    }

    public void SetCustomer(User customer){
        this.customer = customer;
    }

    public void SetRentTime(float rentTime){
        this.rentTime = rentTime;
    }

    public void SetStatus(String status){
        this.status = status;
    }

    public void SetProduct(Product product){
        this.product = product;
    }


    // getters
    public User GetProvider(){
        return provider;
    }

    public User GetCustomer(){
        return customer;
    }

    public float GetRentTime(){
        return rentTime;
    }

    public String GetStatus(){
        return status;
    }

    public Product GetProduct() {
        return product;
    }

    public int GetRentId(){
        return rentId;
    }

}