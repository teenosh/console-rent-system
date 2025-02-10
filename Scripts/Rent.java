package Scripts;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Rent{
    private int provider_id;
    private int customer_id;
    private int product_id;
    private double rentTime;
    private String status; // Canceled, Pending, Ended
    private int rentId;
    private LocalDateTime rentStart;
    private LocalDateTime currentTime;
    private LocalDateTime rentEnd;

    private static TimeManager timeManager = new TimeManager();

    Rent(int id){
        rentId = id;
    }

    Rent(int id, int providerId, int customerId, double rentTime, String status, int productId){
        this(id);
        SetProviderId(providerId);
        SetCustomerId(customerId);
        SetRentTime(rentTime);
        SetStatus(status);
        SetProductId(productId);
        rentStart = LocalDateTime.now();
        rentEnd = GetRentEnd();
    }


    public void ExtendTime(float amount){
        rentTime += amount;
        rentEnd = GetRentEnd();
    }

    public String PrintInformation(){
        return (this.GetRentId() + ": Product #" + GetProductId() + " from User #"+ GetProviderId() + " to User #" + GetCustomerId() + " | until " + this.GetRentEnd().format(timeManager.GetDateFormat()) + "( " + timeManager.CalculateTimeLeft(this.GetRentStart(), this.GetRentEnd(), this.GetRentTime()) + " hours left) " + "Status - " + this.GetStatus());
    }

    // setters

    public void SetProviderId(int id){
        this.provider_id = id;
    }

    public void SetCustomerId(int id){
        this.customer_id = id;
    }

    public void SetRentTime(double rentTime){
        this.rentTime = rentTime;
    }

    public void SetStatus(String status){
        this.status = status;
    }

    public void SetProductId(int id){
        this.product_id = id;
    }


    // getters
    public int GetId() {
        return rentId;
    }

    public int GetProviderId(){
        return provider_id;
    }

    public int GetCustomerId(){
        return customer_id;
    }

    public double GetRentTime(){
        return rentTime;
    }

    public String GetStatus(){
        return status;
    }

    public int GetProductId() {
        return product_id;
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