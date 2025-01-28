package Scripts;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Rent{
    private User provider;
    private User customer;
    private Product product;
    private double rentTime;
    private String status; // Canceled, Pending, Ended
    private int rentId;
    private static int id_gen = 1;
    private LocalDateTime rentStart;
    private LocalDateTime currentTime;
    private LocalDateTime rentEnd;

    private TimeManager timeManager;

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
        rentEnd = GetRentEnd();
    }


    public void ExtendTime(float amount){
        rentTime += amount;
        rentEnd = GetRentEnd();
    }

    public void PrintInformation(){
        System.out.println(this.GetRentId() + ": " + GetProduct().GetName() + " (" + GetProduct().GetQuantity() + ") from "+ GetProvider().GetName() + " to " + GetCustomer().GetName() + " | until " + this.GetRentEnd().format(timeManager.GetDateFormat()) + "( " + timeManager.CalculateTimeLeft(this.GetRentStart(), this.GetRentEnd(), this.GetRentTime()) + " hours left) " + "Status - " + this.GetStatus());
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

    public double GetRentTime(){
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

    public LocalDateTime GetRentStart() {
        return rentStart;
    }

    public LocalDateTime GetCurrentTime() {
        currentTime = LocalDateTime.now();
        return currentTime;
    }

    public LocalDateTime GetRentEnd() {
        return timeManager.CalculateRentTime(this.GetRentTime(), GetRentStart());
    }
}